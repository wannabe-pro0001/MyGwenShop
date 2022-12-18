package GwenShop.com.Service;

import GwenShop.com.entity.Product;

import javax.persistence.EntityManager;
import java.util.List;

public interface IProductService {
    public List<Product> findProductByName(String searchString);
    public List<Product> findAll(int page, int pageSize);
    public List<Product> findAll(EntityManager entityManager);
    public Product findProductById(int prodId);
    public List<String> findProductImages(int id, EntityManager entityManager);
    public void Insert(EntityManager entityManager, Product product, String[] images);
    void update(Product product, String[] ImageList);
    public void delete(EntityManager entityManager, int idProd);
    public int count();
    public Product findProductById(int prodId, EntityManager entityManager);
}
