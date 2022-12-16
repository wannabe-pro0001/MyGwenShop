package GwenShop.com.Service;

import GwenShop.com.entity.*;

import java.util.List;

public interface IUserService {
    public void createAccount(Users user);
    public void update(Users user);
    public void delete(int userID);
    public List<Users> findAll();
    public Users findByEmail(String email);
    public List<Users> findUsersByName(String searchString);
    public Users findById(int userid);
    public void addWishList(Product product, Users user);
    public void removeWishList(WishListItem item, Users user);
    public void addReview(int userID, int prodID, String text);
    public void removeReview(Review review);
    public String checkDelivery(Order order);
}
