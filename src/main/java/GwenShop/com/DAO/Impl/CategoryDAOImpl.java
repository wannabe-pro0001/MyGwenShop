package GwenShop.com.DAO.Impl;

import GwenShop.com.DAO.ICategoryDAO;
import GwenShop.com.entity.Category;
import GwenShop.com.entity.Users;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoryDAOImpl implements ICategoryDAO {
    private EntityManager enma = JPAConfig.getEntityManager();
    private EntityTransaction trans = enma.getTransaction();

    @Override
    public void insert(Category category) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
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
        EntityManager enma = JPAConfig.getEntityManager();
        return enma.find(Category.class, cateid);
    }

    @Override
    public List<Category> findAll(EntityManager entityManager) {
        TypedQuery<Category> query= entityManager.createNamedQuery("Category.findAll", Category.class);
        return query.getResultList();
    }
    @Override
    public List<Category> findAll() {
        TypedQuery<Category> query= enma.createNamedQuery("Category.findAll", Category.class);
        return query.getResultList();
    }

    @Override
    public List<Category> findByCategoryName(String catName) {
        return null;
    }
}
