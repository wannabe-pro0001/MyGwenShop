package GwenShop.com.DAO.Impl;

import GwenShop.com.DAO.IUserDAO;
import GwenShop.com.entity.*;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    @Override
    public void createAccount(Users user) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(user);
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
    public void update(Users user) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.merge(user);
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
    public void delete(int userID) {

    }

    @Override
    public List<Users> findAll() {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        TypedQuery<Users> query= enma.createNamedQuery("Users.findAll", Users.class);
        return query.getResultList();
    }

    @Override
    public Users findByEmail(String email) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        Users user = null;
        try{
            user = (Users)enma.createQuery("SELECT u FROM Users u WHERE u.email = :email", Users.class)
                    .setParameter("email", email)
                    .getSingleResult();
        }
        catch (NoResultException nrr){
            return null;
        }
        return user;
    }

    @Override
    public List<Users> findUsersByName(String searchString) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        String jpql = "SELECT u FROM Users u WHERE u.fullName like :name";
        TypedQuery<Users> query= enma.createQuery(jpql, Users.class);
        query.setParameter("name", "%" + searchString + "%");
        return query.getResultList();
    }

    @Override
    public Users findById(int userid) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        Users user = enma.find(Users.class, userid);
        return user;
    }

    @Override
    public void addWishList(Product product, Users user) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        WishListItem item = user.AddWishList(product);
        try{
            trans.begin();
            enma.persist(item);
            trans.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            trans.rollback();
            throw e;
        }
        finally {
            enma.close();
        }
    }

    @Override
    public void removeWishList(WishListItem item, Users user) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        WishListItem term = user.RemoveWishList(item);
        try{
            trans.begin();
            if (enma.find(WishListItem.class, item) != null)
                enma.remove(item);
            trans.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            trans.rollback();
            throw e;
        }
        finally {
            enma.close();
        }
    }

    @Override
    public void addReview(int userID, int prodID, String text) {

    }

    @Override
    public void removeReview(Review review) {

    }

    @Override
    public String checkDelivery(Order order) {
        return null;
    }
}
