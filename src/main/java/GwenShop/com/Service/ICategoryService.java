package GwenShop.com.Service;

import GwenShop.com.entity.Category;

import java.util.List;

public interface ICategoryService {
    void insert(Category category);
    void update(Category category);
    void delete(int cateId) throws Exception;
    Category findById(int cateid);
    List<Category> findAll();
    List<Category> findByCategoryName(String catName);
}
