package GwenShop.com.entity;

import GwenShop.com.entity.CompositeKey.CartItemID;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CartItem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@IdClass(CartItemID.class)
public class CartItem implements Serializable {
    private static final long serialVersionUID = 1L;


    //Tạo quan hệ bảng Many to one

    public CartItem (Cart cart, Product product){
        this.cart =cart;
        this.product = product;
        this.amount = 1;
    }
    @Id
    @ManyToOne
    @JoinColumn(name="CartId")
    private Cart cart;

    @Id
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "amount")
    private int amount;

}
