package GwenShop.com.entity.CompositeKey;

import GwenShop.com.entity.Cart;
import GwenShop.com.entity.Product;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
public class CartItemID implements Serializable {
    private Cart cart;
    private Product product;

    //Constructor
    public CartItemID(Cart cartID, Product prodID){
        this.cart = cartID;
        this.product = prodID;
    }

    //equal hash code

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cart, product);
    }
}
