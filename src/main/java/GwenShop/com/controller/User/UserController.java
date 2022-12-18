package GwenShop.com.controller.User;

import GwenShop.com.Service.IUserService;
import GwenShop.com.Service.Impl.UserServiceImpl;
import GwenShop.com.entity.Users;
import GwenShop.com.entity.WishListItem;
import GwenShop.com.util.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/user", "/user/info", "/user/wishlist", "/user/changePasswd", "/user/update"})
public class UserController extends HttpServlet {
    IUserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("changePasswd")){
            changePasswd(req, resp);
        } else if (url.contains("update")) {
            updateUser(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("info")){
            UserGet(req, resp);
        } else if (url.contains("wishlist")) {
            wishListGet(req, resp);
        }
    }

    private void UserGet(HttpServletRequest req, HttpServletResponse resp){
        try{
            HttpSession session = req.getSession();
            Users user = (Users) session.getAttribute("account");
            if (session != null && user != null){

            }else{
                req.setAttribute("message", "Vui lòng đăng nhập để tiếp tục");
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void wishListGet(HttpServletRequest req, HttpServletResponse resp){
        try{
            HttpSession session = req.getSession();
            Users user = (Users) session.getAttribute("account");
            if (session != null && user != null){
                //int userID = user.getId();
                List<WishListItem> items = user.getWishListItems();
                req.setAttribute("arr_items[]", items);
            }else{
                req.setAttribute("message", "Vui lòng đăng nhập để tiếp tục");
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void changePasswd(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        Users user = (Users) session.getAttribute("account");
        try{
            if(session != null && user != null){
                HashPassword pw = new HashPassword();
                String newPass = pw.hash(req.getParameter("newPasswd"));

                String result = userService.UpdatePasswd(user, newPass);
                req.setAttribute("message", result);
                resp.sendRedirect(req.getContextPath()+"/user/info");
            } else{
                req.setAttribute("message", "vui lòng đăng nhập để tiếp tục");
                resp.sendRedirect(req.getContextPath()+"/login");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void updateUser(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        Users user = (Users) session.getAttribute("account");
        try{
            if (session != null && user != null){
                String addr = req.getParameter("addr");
                String phoneNo = req.getParameter("phoneNo");
                String fullName = req.getParameter("fullName");

                String mess = userService.update(user, addr, phoneNo, fullName);
                req.setAttribute("message", mess);
                resp.sendRedirect(req.getContextPath()+"/user/info");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
