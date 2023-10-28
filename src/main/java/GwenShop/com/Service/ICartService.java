package GwenShop.com.Service;

import GwenShop.com.entity.Cart;

import java.util.List;

public interface ICartService {
    public boolean existCart (int userId);
    public Cart findCartByUserId (int userId);
    public void insert (Cart cart);
    public void delete (int cartId)  throws Exception;
    public void update (Cart cart);
    int QuantityCount (int cartId);
}
