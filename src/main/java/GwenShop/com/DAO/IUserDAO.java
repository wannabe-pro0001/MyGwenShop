package GwenShop.com.DAO;

import GwenShop.com.entity.*;

import java.util.List;

public interface IUserDAO {
    public void createAccount(Users user);
    public void update(Users user);
    public void delete(int userID);
    void updatePasswd(Users user);
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
