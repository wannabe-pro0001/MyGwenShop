package GwenShop.com.DAO.Impl;

import GwenShop.com.DAO.IReviewDAO;
import GwenShop.com.entity.Review;
import GwenShop.com.util.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ReviewDAOImpl implements IReviewDAO {
    @Override
    public Review findReviewByID(int ReviewID) {
        EntityManager enma = JPAConfig.getEntityManager();
        Review review = enma.find(Review.class, ReviewID);
        return review;
    }
}
