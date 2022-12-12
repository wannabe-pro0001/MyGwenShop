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
            findAll(request, response);
        }
        else {
            RequestDispatcher rq = request.getRequestDispatcher("views/shop/category.jsp");
            rq.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        if(url.contains("category/load-table"))
        {
            findAll(request, response);
        }
        else {
            RequestDispatcher rq = request.getRequestDispatcher("views/admin/category.jsp");
            rq.forward(request,response);
        }
    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try{
            response.setCharacterEncoding("UTF-8");
            List<Category> categories = categoryDAO.findAll();
            request.setAttribute("cate", categories);
            System.out.println("Im here");
            request.getRequestDispatcher("/views/shop/category.jsp").forward(request,response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
