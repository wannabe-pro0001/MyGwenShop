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
		String regex = "0[0-9]{9}";
		Pattern ptrn = Pattern.compile(regex);
		Matcher match = ptrn.matcher(phoneNo);

		return (match.find() && match.group().equals(phoneNo));
	}

	private boolean IsValidPasswd(String pass){
		return (pass.length() >= 6);
	}

	@Override
	public String createAccount(Users user) {
		if (!IsPhoneValid(user.getPhoneNumber())) {
			return "Số điện thoại không hợp lệ";
		}
		userDAO.createAccount(user);
		return "Thêm thành công";
	}

	@Override
	public void update(Users user) {
		userDAO.update(user);
	}

	@Override
	public String update(Users user, String addr, String phoneNo, String fullName) {
		if (!IsPhoneValid(phoneNo)){
			return "Số đện thoại không hợp lệ";
		}
		if (fullName.isEmpty()){
			return "Tên không được trống";
		}
		user.setAddr(addr);
		user.setPhoneNumber(phoneNo);
		user.setFullName(fullName);

		userDAO.update(user);
		return "Cập nhật thành công";
	}

	@Override
	public void delete(int userID) {
		userDAO.delete(userID);
	}

	@Override
	public String UpdatePasswd(Users user, String OldPass, String passwd) {
		String msg="";
		if(passwd.length() < 6){
			msg = "Xâu quá ngắn! Độ dài xâu phải lớn hơn hoặc bằng 6";
		} else if (!user.getPasswd().equals(OldPass)) {
			msg = "Nhập mật khẩu cũ không đúng";
		} else if (user.getPasswd().equals(passwd)) {
			msg = "Mật khẩu mới trùng mật khẩu cũ";
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
