package GwenShop.com.DAO.Impl;

import GwenShop.com.DAO.IWishListDAO;
import GwenShop.com.entity.Product;
import GwenShop.com.entity.Users;
import GwenShop.com.entity.WishListItem;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class WishListDAOImpl implements IWishListDAO {
    @Override
    public List<WishListItem> findAll() {
        EntityManager enma = JPAConfig.getEntityManager();

        TypedQuery<WishListItem> query = (TypedQuery<WishListItem>) enma.createQuery("SELECT item FROM WishListItem item");
        return query.getResultList();
    }

    @Override
    public List<WishListItem> findByUserID(int userID) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        String jpql = "SELECT w FROM WishListItem w WHERE w.user.id = :id";
        TypedQuery<WishListItem> query= enma.createQuery(jpql, WishListItem.class);
        query.setParameter("id", userID);
        return query.getResultList();
    }

    @Override
    public void add(WishListItem item) {

    }

    @Override
    public void remove(WishListItem item) {

    }
}
