package GwenShop.com.DAO;

import GwenShop.com.entity.Product;
import GwenShop.com.entity.Users;
import GwenShop.com.entity.WishListItem;

import java.util.List;

public interface IWishListDAO {
    List<WishListItem> findAll();
    List<WishListItem> findByUserID(int userID);
    void add(WishListItem item);
    void remove(WishListItem item);
}
