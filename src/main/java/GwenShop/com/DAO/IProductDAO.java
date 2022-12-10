package GwenShop.com.DAO;

import GwenShop.com.entity.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> findProductByName(String searchString);
    List<Product> findAll(int page, int pageSize);
    int count();
    Product findProductById(int prodId);
}
