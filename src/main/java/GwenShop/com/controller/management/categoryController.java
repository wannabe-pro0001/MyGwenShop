package GwenShop.com.controller.management;

import GwenShop.com.Service.ICategoryService;
import GwenShop.com.Service.Impl.CategoryServiceImpl;
import GwenShop.com.entity.Category;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/category", "/category/load-table"})
public class categoryController extends HttpServlet {
    ICategoryService categoryDAO = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        if(url.contains("category/load-table"))
        {
            findAll(response);
        }
        else {
            RequestDispatcher rq = request.getRequestDispatcher("views/admin/category.jsp");
            rq.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void findAll(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        List<Category> categories = categoryDAO.findAll();
        PrintWriter out = response.getWriter();
        out.println("<thead><tr>\n" +
                "    <th></th>\n" +
                "    <th>ID</th>\n" +
                "    <th>Danh mục</th>\n" +
                "    <th>Tổng sản phẩm</th>\n" +
                "    <th></th>\n" +
                "</tr><thead><tbody>");
        for(Category c: categories){
            out.println("<tr>\n" +
                    "<td>\n" +
                    "     <input type=\"checkbox\">\n" +
                    "</td>\n" +
                    "<td class=\"col__id-category\">"+c.getId()+"</td>\n" +
                    "<td class=\"col__category-name\">"+c.getName()+"</td>\n" +
                    "<td class=\"col__category-productAmount\">"+c.getAmount()+"</td> \n" +
                    "<td>\n" +
                    "   <button class=\"btn_Edit\">\n" +
                    "           <i class=\"fa-solid fa-pen-to-square\" style=\"color: white;\"></i>\n" +
                    "   </button>\n" +
                    "   <button class=\"btn_Delete\">\n" +
                    "         <i class=\"fa-solid fa-trash-can\" style=\"color: red;\"></i>\n" +
                    "    </button>\n" +
                    "</td>\n" +
                    "</tr>");
        }
        out.println("</tbody>");
    }
}
