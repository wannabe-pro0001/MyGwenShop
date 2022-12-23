package GwenShop.com.DAO.Impl;

import GwenShop.com.DAO.ICartItemDAO;
import GwenShop.com.entity.CartItem;
import GwenShop.com.entity.CompositeKey.CartItemID;
import GwenShop.com.entity.Product;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CartItemDAOImpl implements ICartItemDAO {


    @Override
    public void insert(CartItem cartItem) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.merge(cartItem);
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
    public void update(CartItem cartItem) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.merge(cartItem);
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
    public void delete(CartItemID cartItemID) throws Exception {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            CartItem cartItem = enma.find(CartItem.class, cartItemID);
            if(cartItem != null) {
                enma.remove(cartItem);
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

    public CartItem findById(int prodId, int cartId){
        EntityManager enma = JPAConfig.getEntityManager();
        CartItem cartItem = (CartItem) enma.createQuery("FROM CartItem I WHERE I.product.id = :prodId and I.cart.id = :cartId").setParameter("prodId", prodId).setParameter("cartId", cartId).getSingleResult();
        return cartItem;
    }
    public CartItem findByProdId (CartItem cartItem) {
        EntityManager enma = JPAConfig.getEntityManager();
        CartItem cartIte = (CartItem) enma.createQuery("FROM CartItem I WHERE I.product = :product and I.cart = : cart").setParameter("product", cartItem.getProduct()).setParameter("cart", cartItem.getCart()).getSingleResult();
        return cartIte;
    }
    public boolean existCartItem(CartItem cartItem) {
        EntityManager enma = JPAConfig.getEntityManager();
/*        boolean prod = enma.createQuery("FROM CartItem I WHERE I.product = :product and I.cart = : cart")
                .setParameter("product", cartItem.getProduct())
                .setParameter("cart", cartItem.getCart())
                .getResultList().size() > 0 ? true : false;*/
        if (enma.find(CartItem.class,
                new CartItemID(cartItem.getCart(), cartItem.getProduct())) != null)
            return true;
        return false;
        //return prod;
    }
}
