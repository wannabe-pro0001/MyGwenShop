package GwenShop.com.DAO;

import GwenShop.com.entity.Product;

import javax.persistence.EntityManager;
import java.util.List;

public interface IProductDAO {
    List<Product> findProductByName(String searchString);
    List<Product> findAll(int page, int pageSize);
    int count();
    Product findProductById(int prodId);
    List<String> findProductImages(int productId);
    void Insert(EntityManager entityManager, Product product, String[] images);
    void update(Product product, String[] ImageList);
    void delete(EntityManager entityManager, int idProd);

}
