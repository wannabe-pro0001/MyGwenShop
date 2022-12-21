package GwenShop.com.controller.admin;

import GwenShop.com.Service.ICategoryService;
import GwenShop.com.Service.IProductService;
import GwenShop.com.Service.Impl.CategoryServiceImpl;
import GwenShop.com.Service.Impl.ProductServiceImpl;
import GwenShop.com.entity.Product;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/product", "/admin/product/load-table", "/admin/product/create", "/admin/product/delete", "/admin/product/edit",
"/admin/product/deleteMany"})
public class productController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    ICategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        EntityManager entityManager = JPAConfig.getEntityManager();
        request.setAttribute("categoryList", categoryService.findAll());
        if(url.contains("product/load-table")){
           findAll(response, entityManager);
        }
        else if(url.contains("product/edit")){
            List<String> productImages = productService.findProductImages(Integer.parseInt(request.getParameter("id")));
            PrintWriter out = response.getWriter();
            for (String img: productImages){
                out.println("<div class=\"image-item_wrapper\">"+
                        "<div class=\"image-item\" style=\"background-image: url('"+img+"');\">n"+
                        " </div>" +
                        "<i class=\"fa-solid fa-circle-minus icon-minus\"></i>\n"+
                        " </div>");
            }
        }
        else {
            request.getRequestDispatcher("/views/admin/product.jsp").forward(request,response);
        }
        entityManager.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        EntityManager entityManager = JPAConfig.getEntityManager();

        if(url.contains("create")){
            insert(request, response, entityManager);
        }
        else if(url.contains("product/deleteMany")){
            deleteMany(request, entityManager);
        }
        else if(url.contains("delete")){
            delete(request, response, entityManager);
        }
        else if(url.contains("product/edit")){
            update(request, entityManager);
        }
        else if(url.contains("product/load-table")){
            findAll(response, entityManager);
        }
        else {
            request.getRequestDispatcher("/views/admin/product.jsp").forward(request,response);
        }
        entityManager.close();
    }
    public void findAll(HttpServletResponse response, EntityManager entityManager) throws IOException {
        response.setCharacterEncoding("UTF-8");
        IProductService productService = new ProductServiceImpl();
        List<Product> products = productService.findAll(0, 32);
        String header_table = "<thead>"+"<tr>\n" +
                "    <th></th>\n" +
                "    <th>ID</th>\n" +
                "    <th>Ảnh</th>\n" +
                "    <th>Tên sản phẩm</th>\n" +
                "    <th>Mô tả</th>\n" +
                "    <th>Số lượng</th>\n" +
                "    <th>Giá</th>\n" +
                "    <th></th>\n" +
                "</tr>" + "</thead>";
        String data_table = "";
        PrintWriter out = response.getWriter();
        out.println(header_table + "<tbody>");
        for(Product p: products){
            data_table = "<tr>\n" +
                    "<td>\n" +
                    "    <input type=\"checkbox\">\n" +
                    "</td>\n" +
                    "<td class=\"col__id-product\">"+p.getId()+"</td>\n" +
                    "<td class=\"col__id-category\" style=\"display: none;\">"+p.getCategory().getId()+"</td>\n" +
                    "<td class=\"col__product-image\">\n" +
                    "    <div class=\"product-image\" style=\"background-image: url('"+ p.getProductImages().get(0).getImage() +"');\">\n" +
                    "    </div>\n" +
                    "</td>\n" +
                    "<td class=\"col__product-name\">"+p.getName()+"</td>\n" +
                    "<td class=\"col__product-description\">\n" +
                    "    <textarea readonly class=\"product-description\">"+p.getDescription()+"</textarea>\n" +
                    "</td>\n" +
                    "<td class=\"col__amount\">"+p.getAmount()+"</td>\n" +
                    "<td class=\"col__price\">"+p.getPrice()+"</td>\n" +
                    "<td>\n" +
                    "    <div class=\"\" style=\"display: flex; align-items: center;\">\n" +
                    "        <button class=\"btn_Edit\">\n" +
                    "            <i class=\"fa-solid fa-pen-to-square\" style=\"color: white;\"></i>\n" +
                    "        </button>\n" +
                    "        <button class=\"btn_Delete\" name=\"delete\">" +
                    "            <i class=\"fa-solid fa-trash-can\" style=\"color: red;\"></i>\n" +
                    "        </button>\n" +
                    "    </div>\n" +
                    "</td>\n" +
                    "</tr>";
            out.println(data_table);
        }
        out.println("</tbody>");
    }
    public void insert(HttpServletRequest request, HttpServletResponse response, EntityManager entityManager) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            Product product = new Product();
            String[] ImageList= request.getParameterValues("arrayData[]");
            product.setCategory(categoryService.findById(Integer.parseInt(request.getParameter("category"))));
            product.setName(request.getParameter("name"));
            product.setDescription(request.getParameter("description"));
            product.setPrice(Integer.parseInt(request.getParameter("price")));
            product.setAmount(Integer.parseInt(request.getParameter("amount")));
            product.setCategory(categoryService.findById(Integer.parseInt(request.getParameter("category"))));
            productService.Insert(entityManager, product, ImageList);
        }catch (Exception e){
            out.print("error");
            e.printStackTrace();
        }
    }
    public void delete(HttpServletRequest request, HttpServletResponse response,EntityManager entityManager) throws IOException {
        try {
            productService.delete(entityManager, Integer.parseInt(request.getParameter("id")));
        }catch (Exception e){
            response.getWriter().println("error");
            e.printStackTrace();
        }
    }
    public void update(HttpServletRequest request, EntityManager entityManager){
        Product product = new Product();
        String[] ImageList= request.getParameterValues("arrayData[]");
        product.setCategory(categoryService.findById(Integer.parseInt(request.getParameter("category"))));
        product.setId(Integer.parseInt(request.getParameter("id")));
        product.setName(request.getParameter("name"));
        product.setDescription(request.getParameter("description"));
        product.setPrice(Integer.parseInt(request.getParameter("price")));
        product.setAmount(Integer.parseInt(request.getParameter("amount")));
        product.setCategory(categoryService.findById(Integer.parseInt(request.getParameter("category"))));
        productService.update(product, ImageList);
    }
    public void deleteMany(HttpServletRequest request, EntityManager entityManager){
        String[] listId = request.getParameterValues("arrayData[]");
        for(String id: listId){
            try
            {
                productService.delete(entityManager, Integer.parseInt(id));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
