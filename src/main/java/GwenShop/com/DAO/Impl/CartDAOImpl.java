package GwenShop.com.DAO.Impl;

import GwenShop.com.DAO.ICartDAO;
import GwenShop.com.entity.Cart;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CartDAOImpl implements ICartDAO {


    @Override
    public boolean existCart(int userId) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        boolean isCart = enma.createQuery("FROM Cart C WHERE C.user.id = :userId")
                .setParameter("userId", userId)
                .getResultList()
                .size() > 0 ? true : false;
        return isCart;
    }

    @Override
    public Cart findCartByUserId(int userId) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        Cart cart = (Cart) enma.createQuery("SELECT c FROM Cart c WHERE c.user.id = :id", Cart.class).setParameter("id", userId).getSingleResult();
        return cart;
    }

    @Override
    public void insert(Cart cart) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(cart);
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
    public void delete(int cartId) throws Exception {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            Cart cart = enma.find(Cart.class, cartId);
            if(cart != null) {
                enma.remove(cart);
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

    @Override
    public void update(Cart cart) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try{
            trans.begin();
            enma.merge(cart);
            trans.commit();
        }
        catch(Exception e){
            e.printStackTrace();
            trans.rollback();
            throw e;
        }
        finally {
            enma.close();
        }
    }
}
