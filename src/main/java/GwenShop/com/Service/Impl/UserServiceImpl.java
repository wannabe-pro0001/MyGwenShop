package GwenShop.com.Service.Impl;

import GwenShop.com.DAO.IUserDAO;
import GwenShop.com.DAO.Impl.UserDAOImpl;
import GwenShop.com.Service.IUserService;
import GwenShop.com.entity.*;

import java.util.List;

public class UserServiceImpl implements IUserService {
	IUserDAO userDAO = new UserDAOImpl();

	@Override
	public void createAccount(Users user) {
		userDAO.createAccount(user);
	}

	@Override
	public void update(Users user) {
		userDAO.update(user);
	}

	@Override
	public void delete(int userID) {
		userDAO.delete(userID);
	}

	@Override
	public List<Users> findAll() {
		return userDAO.findAll();
	}

	@Override
	public Users findByEmail(String email) {
		return userDAO.findByEmail(email);
	}

	@Override
	public List<Users> findUsersByName(String searchString) {
		return userDAO.findUsersByName(searchString);
	}

	@Override
	public Users findById(int userid) {
		return userDAO.findById(userid);
	}

	@Override
	public void addWishList(WishListItem item) {userDAO.addWishList(item);}

	@Override
	public void removeWishList(WishListItem item) {userDAO.removeWishList(item);}

	@Override
	public void addReview(Review review) {userDAO.addReview(review);}

	@Override
	public void removeReview(Review review) {userDAO.removeReview(review);}

	@Override
	public String checkDelivery(Order order) {
		return userDAO.checkDelivery(order);
	}
}
