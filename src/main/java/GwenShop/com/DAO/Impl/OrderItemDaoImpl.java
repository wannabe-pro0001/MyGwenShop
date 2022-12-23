package GwenShop.com.DAO.Impl;

import GwenShop.com.DAO.IOrderItemDao;
import GwenShop.com.entity.*;
import GwenShop.com.entity.CompositeKey.OrderItemId;
import GwenShop.com.util.JPAConfig;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class OrderItemDaoImpl implements IOrderItemDao {
    @Override
    public void insert(OrderItem orderItem) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.merge(orderItem);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void delete(OrderItemId orderItemId) throws Exception{
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            OrderItem orderItem1 = enma.find(OrderItem.class, orderItemId);
            if (orderItem1 != null) {
                enma.remove(orderItem1);
            } else {
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
    public OrderItem findById(int id) {
        EntityManager enma = JPAConfig.getEntityManager();
        OrderItem orderItem = (OrderItem) enma.createQuery("FROM OrderItem I WHERE I.id =:id").setParameter("id", id).getSingleResult();
        return orderItem;
    }

    @Override
    public List<OrderItem> findByOrder(Order orders) {
        EntityManager enma = JPAConfig.getEntityManager();
        List<OrderItem> orderItems = (List<OrderItem>) enma.createQuery("FROM OrderItem I WHERE I.orders =:orders").setParameter("orders", orders).getResultList();
        return orderItems;
    }

}
