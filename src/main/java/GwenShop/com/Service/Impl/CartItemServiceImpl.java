package GwenShop.com.Service.Impl;

import GwenShop.com.DAO.ICartItemDAO;
import GwenShop.com.DAO.Impl.CartItemDAOImpl;
import GwenShop.com.Service.ICartItemService;
import GwenShop.com.entity.CartItem;

public class CartItemServiceImpl implements ICartItemService {
    ICartItemDAO cartItemDao = new CartItemDAOImpl();

    @Override
    public void update(CartItem cartItem) {
        cartItemDao.update(cartItem);
    }
}
