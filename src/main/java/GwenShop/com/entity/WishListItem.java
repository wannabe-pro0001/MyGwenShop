package GwenShop.com.entity;

import GwenShop.com.entity.CompositeKey.WishListItemID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "wishListItem")
@Getter
@Setter
@NoArgsConstructor
@ToString
@IdClass(WishListItemID.class)
public class WishListItem {
    //Tạo quan hệ
    @Id
    @ManyToOne
    @JoinColumn(name = "userID")
    private Users user;

    @Id
    @ManyToOne
    @JoinColumn(name = "prodID")
    private Product product;
}
