package GwenShop.com.controller.User;

import GwenShop.com.Service.ICartItemService;
import GwenShop.com.Service.ICartService;
import GwenShop.com.Service.IProductService;
import GwenShop.com.Service.IUserService;
import GwenShop.com.Service.Impl.CartItemServiceImpl;
import GwenShop.com.Service.Impl.CartServiceImpl;
import GwenShop.com.Service.Impl.ProductServiceImpl;
import GwenShop.com.Service.Impl.UserServiceImpl;
import GwenShop.com.entity.Cart;
import GwenShop.com.entity.CartItem;
import GwenShop.com.entity.Category;
import GwenShop.com.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/product","/product/addToCart","/product/comment"})
public class ProductController extends HttpServlet{
    ICartService cartService = new CartServiceImpl();
    IProductService productService = new ProductServiceImpl();
    ICartItemService cartItemService = new CartItemServiceImpl();
    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        findAll(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("addToCart")){
            addToCart(req, resp);
        }
        else{
            findAll(req, resp);
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
                //Ki???m tra user c?? cart hay ch??a n???u ch??a th?? t???o
                if (!cartService.existCart(userId)) {
                    Cart cart = new Cart(userService.findById(userId));
                    cartService.insert(cart);
                }
                List<Cart> userCart = cartService.findCartByUserId(userId);
                Product product = productService.findProductById(prodId);
                //Ki???m tra s???n ph???m ???? t???n t???i trong gi??? h??ng ch??a
//                if (!cartItemService.existCartItem(product)) {
//                    CartItem cartItem = new CartItem(userCart, product, 1);
//                    cartItemService.insert(userCart.addCartItem(cartItem));
//                }
//                else{
//                    CartItem cartItem = cartItemService.findByProdId(product);
//                    cartItem.setCount(cartItem.getCount() + 1);
//                    cartItemService.update(cartItem);
//                }
            }
        }
        catch  (Exception e) {
            e.printStackTrace();
            req.setAttribute("msg", "Eror: " + e.getMessage());
        }
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp){
        try{
            resp.setCharacterEncoding("UTF-8");
            List<Product> products = productService.findAll(0, 12);
            for(Product item:products){
                System.out.println(products);
            }
            req.setAttribute("product", products);
            RequestDispatcher rq = req.getRequestDispatcher("views/shop/product.jsp");
            rq.forward(req,resp);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
