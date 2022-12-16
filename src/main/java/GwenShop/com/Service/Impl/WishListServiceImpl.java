package GwenShop.com.Service.Impl;

import GwenShop.com.DAO.IWishListDAO;
import GwenShop.com.DAO.Impl.WishListDAOImpl;
import GwenShop.com.Service.IWishListService;
import GwenShop.com.entity.Product;
import GwenShop.com.entity.Users;
import GwenShop.com.entity.WishListItem;

import java.util.List;

public class WishListServiceImpl implements IWishListService {
    IWishListDAO wishListDAO = new WishListDAOImpl();
    @Override
    public List<WishListItem> findAll() {
        return wishListDAO.findAll();
    }

    @Override
    public List<WishListItem> findByUserID(int userID) {
        return wishListDAO.findByUserID(userID);
    }

    @Override
    public void add(WishListItem item) {
        wishListDAO.add(item);
    }

    @Override
    public void remove(WishListItem item) {
        wishListDAO.remove(item);
    }
}
