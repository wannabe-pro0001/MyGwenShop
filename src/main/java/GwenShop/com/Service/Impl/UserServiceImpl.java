package GwenShop.com.Service.Impl;

import GwenShop.com.DAO.IUserDAO;
import GwenShop.com.DAO.Impl.UserDAOImpl;
import GwenShop.com.Service.IUserService;
import GwenShop.com.entity.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServiceImpl implements IUserService {
	IUserDAO userDAO = new UserDAOImpl();
	private boolean IsPhoneValid(String phoneNo){
		Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		Matcher match = ptrn.matcher(phoneNo);

		return (match.find() && match.group().equals(phoneNo));
	}

	@Override
	public void createAccount(Users user) {
		userDAO.createAccount(user);
	}

	@Override
	public void update(Users user) {
		userDAO.update(user);
	}

	@Override
	public String update(Users user, String addr, String phoneNo, String fullName) {
		String msg = "";
		if (IsPhoneValid(phoneNo)){
			user.setAddr(addr);
			user.setPhoneNumber(phoneNo);
			user.setFullName(fullName);

			userDAO.update(user);
			msg = "Cập nhật thành công";
		}
		else{
			msg = "Số đện thoại không hợp lệ";
		}
		return msg;
	}

	@Override
	public void delete(int userID) {
		userDAO.delete(userID);
	}

	@Override
	public String UpdatePasswd(Users user, String passwd) {
		String msg="";
		if(passwd.length() < 6){
			msg = "Xâu quá ngắn! Độ dài xâu phải lớn hơn hoặc bằng 6";
		} else if (user.getPasswd().equals(passwd)) {
			msg = "Mật khẩu cũ trùng với mật khẩu mới";
		} else {
			user.setPasswd(passwd);
			userDAO.updatePasswd(user);
			msg = "Đổi mật khẩu thành công";
		}
		return msg;
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
	public void removeReview(int reviewID) {userDAO.removeReview(reviewID);}

	@Override
	public String checkDelivery(Order order) {
		return userDAO.checkDelivery(order);
	}
}
