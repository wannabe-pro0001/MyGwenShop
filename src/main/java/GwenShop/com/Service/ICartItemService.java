package GwenShop.com.Service;

import GwenShop.com.entity.CartItem;
import GwenShop.com.entity.CompositeKey.CartItemID;
import GwenShop.com.entity.Product;

public interface ICartItemService {
    public void insert(CartItem cartItem);
    public void update(CartItem cartItem);
    public void delete(CartItemID cartItemID) throws Exception;
    public CartItem findById(int prodId, int cartId);

    public CartItem findByProdId (CartItem cartItem);
    public boolean existCartItem(CartItem cartItem);
}
