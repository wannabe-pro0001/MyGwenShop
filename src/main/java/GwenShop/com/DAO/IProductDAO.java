package GwenShop.com.DAO;

import GwenShop.com.entity.Product;

import javax.persistence.EntityManager;
import java.util.List;

public interface IProductDAO {
    public List<Product> findAll(EntityManager entityManager);
    public Product findProductById(int prodId);
    public void Insert(EntityManager entityManager, Product product, String[] images);
    List<Product> findProductByName(String searchString);
    List<Product> findAll(int page, int pageSize);
    int count();
    Product findProductById(int prodId, EntityManager entityManager);
    public List<String> findProductImages(int id, EntityManager entityManager);
    void update(Product product, String[] ImageList);
    public void delete(EntityManager entityManager, int idProd);
}
