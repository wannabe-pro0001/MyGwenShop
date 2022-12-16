package GwenShop.com.controller.User;

import GwenShop.com.Service.ICategoryService;
import GwenShop.com.Service.Impl.CategoryServiceImpl;
import GwenShop.com.entity.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/category"})
public class CategoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String url = request.getRequestURL().toString();
        findAll(request, response);
        RequestDispatcher rq = request.getRequestDispatcher("views/shop/category.jsp");
        rq.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String url = request.getRequestURL().toString();
        findAll(request, response);
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ICategoryService categoryDAO = new CategoryServiceImpl();

        try{
            response.setCharacterEncoding("UTF-8");
            List<Category> categories = categoryDAO.findAll();
            request.setAttribute("cate", categories);
            RequestDispatcher rq = request.getRequestDispatcher("views/shop/category.jsp");
            rq.forward(request,response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
