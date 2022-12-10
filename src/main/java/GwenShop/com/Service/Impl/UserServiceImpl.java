package GwenShop.com.Service.Impl;

import GwenShop.com.DAO.IUserDAO;
import GwenShop.com.DAO.Impl.UserDAOImpl;
import GwenShop.com.Service.IUserService;
import GwenShop.com.entity.Users;

import java.util.List;

public class UserServiceImpl implements IUserService {
	IUserDAO userDao = new UserDAOImpl();

	@Override
	public void createAccount(Users user) {
		userDao.createAccount(user);
	}

	@Override
	public void update(Users user) {
		userDao.update(user);
	}

	@Override
	public Users findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public List<Users> findUsersByName(String searchString) {
		return userDao.findUsersByName(searchString);
	}

	@Override
	public Users findById(int userid) {
		return userDao.findById(userid);
	}
}
