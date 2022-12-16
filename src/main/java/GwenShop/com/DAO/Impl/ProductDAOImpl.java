package GwenShop.com.DAO.Impl;

import GwenShop.com.DAO.IProductDAO;
import GwenShop.com.entity.Product;
import GwenShop.com.entity.Users;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductDAOImpl implements IProductDAO {
    private EntityManager enma = JPAConfig.getEntityManager();
    private EntityTransaction trans = enma.getTransaction();
    @Override
    public List<Product> findProductByName(String searchString) {
        String jpql = "SELECT p FROM Product p WHERE p.name like :name";
        TypedQuery<Product> query= enma.createQuery(jpql, Product.class);
        query.setParameter("name", "%" + searchString + "%");
        return query.getResultList();
    }

    @Override
    public List<Product> findAll(int page, int pageSize) {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Product> query= enma.createNamedQuery("Product.findAll", Product.class);
        query.setFirstResult(page*pageSize);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

    @Override
    public int count() {
        String jpql = "SELECT COUNT(id) FROM Product p";
        Query query = enma.createQuery(jpql);

        return ((Long)query.getSingleResult()).intValue();
    }

    @Override
    public Product findProductById(int prodId) {
        Product product = enma.find(Product.class, prodId);
        return product;
    }
}
