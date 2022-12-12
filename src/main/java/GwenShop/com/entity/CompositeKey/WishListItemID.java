package GwenShop.com.entity.CompositeKey;

import GwenShop.com.entity.Product;
import GwenShop.com.entity.Users;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
@NoArgsConstructor
public class WishListItemID implements Serializable {
    private Users user;
    private Product product;

    //Constructor
    public WishListItemID(Users userID, Product prodID) {
        this.user = userID;
        this.product = prodID;
    }

    //Equal() and HashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WishListItemID)) return false;
        WishListItemID that = (WishListItemID) o;
        return user.equals(that.user) && product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, product);
    }
}
