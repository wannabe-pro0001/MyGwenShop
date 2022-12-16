package GwenShop.com.entity;

import GwenShop.com.entity.CompositeKey.WishListItemID;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "wishListItem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@IdClass(WishListItemID.class)
public class WishListItem implements Serializable {
    //Tạo quan hệ
    @Id
    @ManyToOne
    @JoinColumn(name = "userID")
    private Users user;

    @Id
    @ManyToOne
    @JoinColumn(name = "prodID")
    private Product product;

    public WishListItem AddWishList()
    {
        List<WishListItem> items = user.getWishListItems();
        items.add(this);
        user.setWishListItems(items);

        items = product.getWishListItems();
        items.add(this);
        product.setWishListItems(items);

        return this;
    }

    public WishListItem RemoveWishList()
    {
        List<WishListItem> items = user.getWishListItems();
        items.remove(this);
        user.setWishListItems(items);

        items = product.getWishListItems();
        items.remove(this);
        product.setWishListItems(items);

        return this;
    }
}
