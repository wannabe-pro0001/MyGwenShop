package GwenShop.com.Service;

import GwenShop.com.entity.Product;

import javax.persistence.EntityManager;
import java.util.List;

public interface IProductService {
    public List<Product> findProductByName(String searchString);
    public List<Product> findAll(int page, int pageSize);
    public int count();
    public Product findProductById(int prodId);
    List<String> findProductImages(int productId);
    void Insert(EntityManager entityManager, Product product, String[] images);
    void update(Product product, String[] ImageList);
    void delete(EntityManager entityManager, int idProd);
}
