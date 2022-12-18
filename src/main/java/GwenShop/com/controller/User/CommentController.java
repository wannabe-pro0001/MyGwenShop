package GwenShop.com.controller.User;

import GwenShop.com.Service.IProductService;
import GwenShop.com.Service.IReviewService;
import GwenShop.com.Service.IUserService;
import GwenShop.com.Service.Impl.ProductServiceImpl;
import GwenShop.com.Service.Impl.ReviewServiceImpl;
import GwenShop.com.Service.Impl.UserServiceImpl;
import GwenShop.com.entity.Product;
import GwenShop.com.entity.Review;
import GwenShop.com.entity.Users;
import GwenShop.com.entity.WishListItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/comment", "/comment/add", "/comment/remove"})
public class CommentController extends HttpServlet {
    IUserService userService = new UserServiceImpl();
    IProductService productService = new ProductServiceImpl();
    IReviewService reviewService = new ReviewServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("add")){
            AddComment(req, resp);
        } else if (url.contains("remove")) {
            RemoveComment(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void AddComment(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        try{
            String review_text = req.getParameter("review_text");
            Users user = (Users) session.getAttribute("account");
            int productID = Integer.parseInt(req.getParameter("productID"));
            Product product = productService.findProductById(productID);
            long millis=System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            //Khởi tạo review
            Review review = new Review();
            review.setUser(user);
            review.setProduct(product);
            review.setReview_text(review_text);
            review.setCreate_at(date);
            //Thêm review vào product và user
            review.AddReview();
            //Gọi tới Service để thêm
            userService.addReview(review);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void RemoveComment(HttpServletRequest req, HttpServletResponse resp){
        try{
            HttpSession session = req.getSession();
            if (session != null && session.getAttribute("account") != null){
                int reviewID = Integer.parseInt(req.getParameter("reviewID"));
                Users user = (Users) session.getAttribute("account");

                //Nhớ check WishList tồn tại hay chưa
                Review item = reviewService.findReviewByID(reviewID);
                //System.out.println(item.getUser().equals(user)); always false ???
                if (item.getUser().getId() == user.getId()){
                    item.RemoveReview();
                    userService.removeReview(reviewID);
                    req.setAttribute("message", "Đã thu hồi");
                }
                else{
                    req.setAttribute("alert", "Không phải bình luận của bạn");
                }
                resp.sendRedirect(req.getContextPath() + "/product/detail");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
