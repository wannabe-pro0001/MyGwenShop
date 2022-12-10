package GwenShop.com.DAO.Impl;

import GwenShop.com.DAO.ICategoryDAO;
import GwenShop.com.entity.Category;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CategoryDAOImpl implements ICategoryDAO {
    private EntityManager enma = JPAConfig.getEntityManager();
    private EntityTransaction trans = enma.getTransaction();

    @Override
    public void insert(Category category) {
        try {
            trans.begin();
            enma.persist(category);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        }finally {
            enma.close();
        }
    }

    @Override
    public void update(Category category) {
        try {
            trans.begin();
            enma.merge(category);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        }finally {
            enma.close();
        }
    }

    @Override
    public void delete(int cateId) throws Exception {
        try {
            trans.begin();
            Category cate = enma.find(Category.class, cateId);
            if (cate != null){
                enma.remove(cate);
            }
            else {
                throw new Exception("Không tìm thấy");
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        }finally {
            enma.close();
        }
    }

    @Override
    public Category findById(int cateid) {
        Category cate = enma.find(Category.class, cateid);
        return null;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public List<Category> findByCategoryName(String catName) {
        return null;
    }
}
