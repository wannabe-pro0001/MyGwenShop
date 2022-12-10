package GwenShop.com.Service.Impl;


import GwenShop.com.DAO.IProductDAO;
import GwenShop.com.DAO.Impl.ProductDAOImpl;
import GwenShop.com.Service.IProductService;
import GwenShop.com.entity.Product;

import java.util.List;


public class ProductServiceImpl implements IProductService {
    IProductDAO productDao = new ProductDAOImpl();

    @Override
    public List<Product> findProductByName(String searchString) {
        return productDao.findProductByName(searchString);
    }

    @Override
    public List<Product> findAll(int page, int pageSize) {
        return productDao.findAll(page, pageSize);
    }

    @Override
    public int count() {
        return productDao.count();
    }

    @Override
    public Product findProductById(int prodId) {
        return productDao.findProductById(prodId);
    }
}
