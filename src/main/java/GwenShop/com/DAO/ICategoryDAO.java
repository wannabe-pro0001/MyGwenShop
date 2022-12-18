package GwenShop.com.DAO;

import GwenShop.com.entity.Category;

import javax.persistence.EntityManager;
import java.util.List;

public interface ICategoryDAO {
    void insert(Category category);
    void update(Category category);
    void delete(int cateId) throws Exception;
    Category findById(int cateid);
    public List<Category> findAll();
    public List<Category> findAll(EntityManager entityManager);
    List<Category> findByCategoryName(String catName);
}
