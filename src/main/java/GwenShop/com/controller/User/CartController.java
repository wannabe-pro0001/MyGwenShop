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
                request.getRequestDispatcher("/views/user/cart.jsp").forward(request,response);
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
            findAll(request, response);
            request.getRequestDispatcher("/views/user/checkout.jsp").forward(request,response);
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

                String address = request.getParameter("address");
                int phone = Integer.parseInt(request.getParameter("phone"));
                BigDecimal total = BigDecimal.valueOf(Integer.parseInt(request.getParameter("total")));

                //tạo order
                Order orders = new Order();
                orderService.insert(orders);
                //thêm orderitem vào order
                Cart cart = cartService.findCartByUserId(userId);
                for (CartItem cartItem : cart.getCartItems()){
                    OrderItem orderItem = new OrderItem();
                    orderItemService.insert(orders.addOrderItem(orderItem));
                }
                //xoa cartitem khoi cart
                for (CartItem cartItem : cart.getCartItems()){
                    cartItemService.delete(cartItem);
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
                int prodId = Integer.parseInt(request.getParameter("prodId"));
                int userId = Integer.parseInt((String) session.getAttribute("userId"));
                Cart userCart = cartService.findCartByUserId(userId);
                Product product = productService.findProductById(prodId);
                cartItemService.delete(new CartItemID(userCart, product));
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
            if (session.getAttribute("userId") == null && !response.isCommitted()) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                int userId = Integer.parseInt((String) session.getAttribute("userId"));
                Cart cart = cartService.findCartByUserId(userId);
                request.setAttribute("cartItems", cart.getCartItems()); //Trả về giá trị cho view
            }
        } catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }
}
