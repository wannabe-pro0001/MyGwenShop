package GwenShop.com.controller.User;

import gwenshop.com.Service.ICartItemService;
import gwenshop.com.Service.ICartService;
import gwenshop.com.Service.IProductService;
import gwenshop.com.Service.IUserService;
import gwenshop.com.Service.Impl.CartItemServiceImpl;
import gwenshop.com.Service.Impl.CartServiceImpl;
import gwenshop.com.Service.Impl.ProductServiceImpl;
import gwenshop.com.Service.Impl.UserServiceImpl;
import gwenshop.com.model.Cart;
import gwenshop.com.model.CartItem;
import gwenshop.com.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/product/addToCart"})
public class ProductController extends HttpServlet{
    ICartService cartService = new CartServiceImpl();
    IProductService productService = new ProductServiceImpl();
    ICartItemService cartItemService = new CartItemServiceImpl();
    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("addToCart")){
            addToCart(req, resp);
        }
    }

    private void addToCart(HttpServletRequest req, HttpServletResponse resp) {
        try {
            HttpSession session = req.getSession(true);
            if(session.getAttribute("userId") == null){
                resp.sendRedirect(req.getContextPath()+"/login");
            }else {
                int userId = Integer.parseInt((String) session.getAttribute("userId"));

                int prodId = Integer.parseInt(req.getParameter("productId"));
                //Kiểm tra user có cart hay chưa nếu chưa thì tạo
                if (!cartService.existCart(userId)) {
                    Cart cart = new Cart(userService.findById(userId));
                    cartService.insert(cart);
                }
                Cart userCart = cartService.findCartByUserId(userId);
                Product product = productService.findProductById(prodId);
                //Kiểm tra sản phẩm đã tồn tại trong giỏ hàng chưa
                if (!cartItemService.existCartItem(product)) {
                    CartItem cartItem = new CartItem(userCart, product, 1);
                    cartItemService.insert(userCart.addCartItem(cartItem));
                }
                else{
                    CartItem cartItem = cartItemService.findByProdId(product);
                    cartItem.setCount(cartItem.getCount() + 1);
                    cartItemService.update(cartItem);
                }
            }
        }
        catch  (Exception e) {
            e.printStackTrace();
            req.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }
    }
}
