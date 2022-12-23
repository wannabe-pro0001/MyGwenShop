package GwenShop.com.Service.Impl;

import GwenShop.com.DAO.IReviewDAO;
import GwenShop.com.DAO.Impl.ReviewDAOImpl;
import GwenShop.com.Service.IReviewService;
import GwenShop.com.entity.Review;

public class ReviewServiceImpl implements IReviewService {
    IReviewDAO reviewDAO = new ReviewDAOImpl();
    @Override
    public Review findReviewByID(int reviewID) {return reviewDAO.findReviewByID(reviewID);}
}
