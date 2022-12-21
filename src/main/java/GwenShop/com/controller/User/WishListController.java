package GwenShop.com.controller.User;

import GwenShop.com.Service.IProductService;
import GwenShop.com.Service.IUserService;
import GwenShop.com.Service.Impl.ProductServiceImpl;
import GwenShop.com.Service.Impl.UserServiceImpl;
import GwenShop.com.entity.Product;
import GwenShop.com.entity.Users;
import GwenShop.com.entity.WishListItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/wishlist/index", "/wishlist/add", "/wishlist/remove"})
public class WishListController extends HttpServlet {
    IUserService userService = new UserServiceImpl();
    IProductService productService = new ProductServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("index")){
            findAll(req, resp);
        } else if (url.contains("add")) {
            addWishList(req, resp);
        } else if (url.contains("remove")) {
            removeWishList(req, resp);
        }

        resp.sendRedirect(req.getContextPath()+"/product");
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

    }

    private void addWishList(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        if (session != null && session.getAttribute("account") != null){
            Users user = (Users) session.getAttribute("account");
            int productID = Integer.parseInt(req.getParameter("productId"));
            Product product = productService.findProductById(productID);

            //Nhớ check WishList tồn tại hay chưa
            WishListItem item = new WishListItem(user, product);
            userService.addWishList(item.AddWishList());
            req.setAttribute("message", "Thêm thành công");
        }
        else{
            req.setAttribute("alert", "Vui lòng đăng nhập để thêm giỏ hàng yêu thích");
        }
    }

    private void removeWishList(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        if (session != null && session.getAttribute("account") != null){
            Users user = (Users) session.getAttribute("account");
            int productID = Integer.parseInt(req.getParameter("productID"));
            Product product = productService.findProductById(productID);

            //Nhớ check WishList tồn tại hay chưa
            WishListItem item = new WishListItem(user, product);
            System.out.println(item);
            userService.removeWishList(item.RemoveWishList());
            req.setAttribute("message", "Bỏ thành công");
        }
        else{
            req.setAttribute("alert", "Vui lòng đăng nhập để thêm giỏ hàng yêu thích");
        }
    }
}
