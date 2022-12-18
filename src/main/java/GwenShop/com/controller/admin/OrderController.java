package GwenShop.com.controller.admin;

import GwenShop.com.Service.IOrderService;
import GwenShop.com.Service.IProductService;
import GwenShop.com.Service.IUserService;
import GwenShop.com.Service.Impl.OrderServiceImpl;
import GwenShop.com.Service.Impl.ProductServiceImpl;
import GwenShop.com.Service.Impl.UserServiceImpl;
import GwenShop.com.entity.Order;
import GwenShop.com.entity.OrderItem;
import GwenShop.com.entity.Product;
import GwenShop.com.entity.Users;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

@WebServlet(urlPatterns = {"/admin/order", "/admin/order/load-table", "/admin/order/status/change", "/admin/order/delete", "/admin/order/detail"})
public class orderController extends HttpServlet {
    IOrderService orderService = new OrderServiceImpl();
    IUserService userService = new UserServiceImpl();
    IProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("load-table")){
            findAll(resp);
        }
        else if(url.contains("order/detail")){
            List<OrderItem> orderdetails = orderService.findbyId(Integer.parseInt(req.getParameter("id"))).getOrderItems();
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            for(OrderItem order: orderdetails){
                Product product = order.getProduct();
                out.println("<div class=\"row\">\n" +
                        "                        <div class=\"image\" style = \"background-image: url('"+product.getProductImages().get(0).getImage()+"');\"></div>\n" +
                        "                        <div class=\"Info\">\n" +
                        "                           <div class=\"\">\n" +
                        "                                <span>"+product.getCategory().getName()+"</span>\n" +
                        "                                <span>"+product.getName()+"</span>\n" +
                        "                           </div>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"amount\">\n" +
                        "                            <span>"+order.getAmount()+"</span>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"price\">\n" +
                        "                            <span>"+product.getPrice()+"vnđ</span>\n" +
                        "                        </div>\n" +
                        "                    </div>");
            }
            out.println("<div class=\"status\">\n" +
                    "                        <select name=\"untreated\" id=\"\">\n" +
                    "                            <option value=\"untr\">Chưa xử lý</option>\n" +
                    "                            <option value=\"processing\">Đang xử lý</option>\n" +
                    "                            <option value=\"complete\">Đã hoàn thành</option>\n" +
                    "                        </select>\n" +
                    "                    </div>");
        }
        else {
            RequestDispatcher rq = req.getRequestDispatcher("/views/admin/order.jsp");
            rq.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if(url.contains("status/change")){
            EntityManager entityManager = JPAConfig.getEntityManager();
            int idOrder = Integer.parseInt(req.getParameter("id"));
            String status = req.getParameter("status");
            System.out.println();
            entityManager.createQuery("update Order set status = '"+status+"' where id = 4").executeUpdate();
        }
    }

    private void FindAll(HttpServletRequest req, HttpServletResponse resp){
        try{
            HttpSession session = req.getSession();
            if (session != null && session.getAttribute("account") != null) {
                Users user = (Users) session.getAttribute("account");
                req.setAttribute("username", user.getFullName());
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

    public String getStatusOrder(String stt){
        System.out.println(stt);
        if(Objects.equals(stt, "complete")){
            return "" +
                    "<div class=\"status_complete\">\n" +
                    "        <i class=\"fa-solid fa-check check\"></i>\n" +
                    "        Đã hoàn thành\n" +
                    "</div>";
        }
        else if(Objects.equals(stt, "untreated")){
            return "" +
                    "    <div class=\"status_untreated\">\n" +
                    "        <i class=\"fa-solid fa-circle-exclamation error\"></i>\n" +
                    "        Chưa xử lý\n" +
                    "    </div>";
        }
        else {
            return "" +
                    "<div class=\"status_processing\">\n" +
                    "        <i class=\"fa-solid fa-triangle-exclamation warning\"></i>\n" +
                    "        Đang xử lý\n" +
                    "</div>";
        }
    }
    public void findAll(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        EntityManager entityManager = JPAConfig.getEntityManager();
        out.println("" +
                "<thead>\n" +
                "    <tr>\n" +
                "        <th></th>\n" +
                "        <th>ID</th>\n" +
                "        <th>Khách hàng</th>\n" +
                "        <th>Địa chỉ</th>\n" +
                "        <th>Số điện thoại</th>\n" +
                "        <th>Trạng thái</th>\n" +
                "        <th>Người thực hiện</th>\n" +
                "        <th>Tổng tiền</th>\n" +
                "        <th>Ngày tạo</th>        \n" +
                "        <th></th>        \n" +
                "    </tr>\n" +
                "</thead><tbody>");
        List<Order> orders = orderService.findAll();

        for(Order o: orders){
            String employee;
            try {
                employee = o.getEmployee().getFullName();
            }
            catch (Exception e){
                employee = "Chưa có người duyệt";
            }
            out.println("" +
                    "<tr>\n" +
                    "<td>\n" +
                    "    <input type=\"checkbox\">\n" +
                    "</td>\n" +
                    "<td>"+o.getId()+"</td>\n" +
                    "<td>"+o.getFullName()+"</td>\n" +
                    "<td>"+o.getAddress()+"</td>\n" +
                    "<td>"+o.getPhoneNumber()+"</td>\n" +
                    "<td class=\"\" name = \"status\">\n" +
                    getStatusOrder(o.getStatus()) +
                    "</td>\n" +
                    "<td>"+
                    employee +
                    "</td>\n" +
                    "<td>"+o.getPrice()+"</td>\n" +
                    "<td>"+o.getCreate_at()+"</td>\n" +
                    "<td>\n" +
                    "    <div class=\"\" style=\"display: flex; align-items: center;\">\n" +
                    "        <button class=\"btn_ShowInfo_Order\">\n" +
                    "            <i class=\"fa-solid fa-file-invoice-dollar\" style=\"color: white;\"></i>\n" +
                    "        </button>\n" +
                    "        <button class=\"btn_Delete\">\n" +
                    "            <i class=\"fa-solid fa-trash-can\" style=\"color: red;\"></i>\n" +
                    "        </button>\n" +
                    "    </div>\n" +
                    "</td>\n" +
                    "</tr>");
        }
        out.println("</tbody>");
    }


}
