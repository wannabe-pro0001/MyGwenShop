package GwenShop.com.DAO.Impl;

import GwenShop.com.DAO.IUserDAO;
import GwenShop.com.entity.Users;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    private EntityManager enma = JPAConfig.getEntityManager();
    private EntityTransaction trans = enma.getTransaction();

    @Override
    public void createAccount(Users user) {
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
    public Users findByEmail(String email) {
        Users user = enma.find(Users.class, email);
        return user;
    }

    @Override
    public List<Users> findUsersByName(String searchString) {
        String jpql = "SELECT u FROM Users u WHERE u.fullname like :name";
        TypedQuery<Users> query= enma.createQuery(jpql, Users.class);
        query.setParameter("name", "%" + searchString + "%");
        return query.getResultList();
    }

    @Override
    public Users findById(int userid) {
        Users user = enma.find(Users.class, userid);
        return user;
    }
}
