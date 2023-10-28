package GwenShop.com.controller.User;

import GwenShop.com.Service.*;
import GwenShop.com.Service.Impl.*;
import GwenShop.com.entity.*;
import GwenShop.com.entity.CompositeKey.CartItemID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(urlPatterns ={"/cart", "/cart/delete", "/cart/updateQuantity", "/cart/checkout"})
public class CartController extends HttpServlet {
    IUserService userService = new UserServiceImpl();
    IProductService productService = new ProductServiceImpl();
    ICartService cartService = new CartServiceImpl();
    ICartItemService cartItemService = new CartItemServiceImpl();
    IOrderService orderService = new OrderServiceImpl();
    IOrderItemService orderItemService = new OrderItemServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        if (url.contains("delete")){
            deleteCartItem(request, response);
            findAll(request, response);
            if (!response.isCommitted()) {
                request.getRequestDispatcher("/views/user/cart.jsp").forward(request, response);
            }
        } else if (url.contains("checkout")) {
            getCheckout(request, response);
        } else if(url.contains("updateQuantity")) {
            updateQuantity(request, response);
        }
        else {
            findAll(request, response);
            if (!response.isCommitted()){
                request.getRequestDispatcher("views/user/GioHang/giohang.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        if (url.contains("updateQuantity")) {
            updateQuantity(request, response);
        } else if (url.contains("checkout")) {
            postCheckout(request, response);
            findAllOrder(request, response);
            request.getRequestDispatcher("/views/user/OrderList.jsp").forward(request,response);
        }
    }

    private void getCheckout(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(true);
            if (session.getAttribute("account") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                Users userId = (Users) session.getAttribute("account");
                Cart cart = cartService.findCartByUserId(userId.getId());
                request.setAttribute("cartItem", cart.getCartItems());
                request.getRequestDispatcher("/views/user/ThanhToan/thanhtoan.jsp").forward(request, response);
            }
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void postCheckout(HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession(true);
            if (session.getAttribute("userId") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                int userId = Integer.parseInt((String) session.getAttribute("userId"));
                Users user = userService.findById(userId);

                String fullName = request.getParameter("billingName");
                String address = request.getParameter("billingAddress");
                String phone = request.getParameter("billingPhone");
                String note = request.getParameter("note");
                //int total = Integer.parseInt(request.getParameter("total"));
                int total = 0;
                Cart cart = cartService.findCartByUserId(userId);

                for (CartItem cartItem : cart.getCartItems()){
                    int price = cartItem.getProduct().getPrice();
                    int amount = cartItem.getAmount();

                    total += price*amount;
                }

                //tạo order
                Order orders = new Order(fullName, address, phone, total, user);
                orderService.insert(orders);

                //thêm orderitem vào order
                for (CartItem cartItem : cart.getCartItems()){
                    OrderItem orderItem = new OrderItem(orders, cartItem.getProduct(), cartItem.getAmount());
                    //orderItemService.insert(orders.addOrderItem(orderItem));
                    orderItemService.insert(orderItem);
                }
                //xoa cartitem khoi cart
                for (CartItem cartItem : cart.getCartItems()){
                    cartItemService.delete(new CartItemID(cart, cartItem.getProduct()));
                }

                //Thêm order vào db
                request.setAttribute("orderMsg", "Đặt hàng thành công");

                //Xóa cart của user
            }
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }
    private void updateQuantity(HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession(true);
            if (session.getAttribute("userId") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                int cartId = Integer.parseInt(request.getParameter("cartId"));
                int prodId = Integer.parseInt(request.getParameter("prodId"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                CartItem cartItem = cartItemService.findById(prodId, cartId);
                cartItem.setAmount(quantity);
                cartItemService.update(cartItem);
            }
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }

    private void deleteCartItem(HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession(true);
            if (session.getAttribute("userId") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                int prodId = Integer.parseInt(request.getParameter("productId"));
                int userId = Integer.parseInt((String) session.getAttribute("userId"));
                Cart userCart = cartService.findCartByUserId(userId);
                Product product = productService.findProductById(prodId);
                cartItemService.delete(new CartItemID(userCart, product));
                response.sendRedirect(request.getContextPath() + "/cart");
            }
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }

    private void findAllOrder(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            HttpSession session = request.getSession(true);
//            if (session.getAttribute("userId") == null && !response.isCommitted()) {
//                response.sendRedirect(request.getContextPath() + "/login");
//            }
//            else {
//                int userId = Integer.parseInt((String) session.getAttribute("userId"));
//                List<Orders> orders = orderService.findbyUserId(userId);
//                request.setAttribute("orders", orders); //Trả về giá trị cho view
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//            request.setAttribute("msg", "Eror: " + e.getMessage());
//        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(true);
            if (session.getAttribute("account") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                Users userId = (Users) session.getAttribute("account");
                Cart cart = cartService.findCartByUserId(userId.getId());
                request.setAttribute("cartItem", cart.getCartItems()); //Trả về giá trị cho view
                request.getRequestDispatcher("/views/user/GioHang/giohang.jsp").forward(request,response);
            }
        } catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }
    private void findAllGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(true);
            if (session.getAttribute("account") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                Users userId = (Users) session.getAttribute("account");
                Cart cart = cartService.findCartByUserId(userId.getId());
                request.setAttribute("cartItem", cart.getCartItems()); //Trả về giá trị cho view
                request.getRequestDispatcher("/views/user/GioHang/giohang.jsp").forward(request,response);
            }
        } catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }

}
