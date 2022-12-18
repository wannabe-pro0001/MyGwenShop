package GwenShop.com.Service;

import GwenShop.com.entity.*;

import java.util.List;

public interface IUserService {
    public void createAccount(Users user);
    public void update(Users user);
    String update(Users user, String addr, String phoneNo, String fullName);
    public void delete(int userID);

    String UpdatePasswd(Users user, String passwd);
    public List<Users> findAll();
    public Users findByEmail(String email);
    public List<Users> findUsersByName(String searchString);
    public Users findById(int userid);
    public void addWishList(WishListItem item);
    public void removeWishList(WishListItem item);
    public void addReview(Review review);
    public void removeReview(int reviewID);
    public String checkDelivery(Order order);
}
