package GwenShop.com.controller.User;

import GwenShop.com.Service.IOrderService;
import GwenShop.com.Service.Impl.OrderServiceImpl;
import GwenShop.com.entity.Order;
import GwenShop.com.entity.Product;
import GwenShop.com.entity.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/order/index", "/order/add", "/order/delete", "/order/update"})
public class OrderController extends HttpServlet {
    IOrderService orderService = new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("index")){
            FindByUserId(req, resp);
        }
        else if (url.contains("add")){

        } else if (url.contains("delete")) {

        } else if (url.contains("update")) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void FindByUserId(HttpServletRequest req, HttpServletResponse resp){
        try{
            HttpSession session = req.getSession();
            if (session != null && session.getAttribute("account") != null) {
                Users user = (Users) session.getAttribute("account");
                resp.setCharacterEncoding("UTF-8");

                List<Order> orders = orderService.findbyUserId(user.getId());
                req.setAttribute("order", orders);
                RequestDispatcher rq = req.getRequestDispatcher("views/shop/order.jsp");
                rq.forward(req,resp);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
