package GwenShop.com.Service.Impl;

import GwenShop.com.DAO.ICartItemDAO;
import GwenShop.com.DAO.Impl.CartItemDAOImpl;
import GwenShop.com.Service.ICartItemService;
import GwenShop.com.entity.CartItem;
import GwenShop.com.entity.CompositeKey.CartItemID;
import GwenShop.com.entity.Product;

public class CartItemServiceImpl implements ICartItemService {
    ICartItemDAO cartItemDao = new CartItemDAOImpl();

    @Override
    public void insert(CartItem cartItem) {
        cartItemDao.insert(cartItem);
    }
    public void update(CartItem cartItem) {
        cartItemDao.update(cartItem);
    }
    public void delete(CartItemID cartItemID) throws Exception {cartItemDao.delete(cartItemID);}
    public CartItem findById(int prodId, int cartId){
        return cartItemDao.findById(prodId, cartId);
    }

    public CartItem findByProdId (CartItem cartItem) {return cartItemDao.findByProdId(cartItem);}
    public boolean existCartItem(CartItem cartItem) { return cartItemDao.existCartItem(cartItem); }
}
