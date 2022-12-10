package GwenShop.com.DAO.Impl;

import GwenShop.com.DAO.IOrderDAO;
import GwenShop.com.entity.Order;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderDAOImpl implements IOrderDAO {
    private EntityManager enma = JPAConfig.getEntityManager();
    private EntityTransaction trans = enma.getTransaction();

    @Override
    public Order findbyId(int id) {
        Order order = enma.find(Order.class, id);
        return order;
    }

    @Override
    public List<Order> findbyUserId(int id) {
        String jpql = "SELECT o FROM Order o WHERE o.userId = :id";
        TypedQuery<Order> query= enma.createQuery(jpql, Order.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public void insert(Order order) {
        try {
            trans.begin();
            enma.persist(order);
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
    public void update(Order order) {
        try {
            trans.begin();
            enma.merge(order);
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
    public void delete(Order order) throws Exception {
        try {
            trans.begin();
            Order ord = enma.find(Order.class,order);
            if(ord != null) {
                enma.remove(ord);
            }else {
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
}
