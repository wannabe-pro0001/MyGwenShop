package GwenShop.com.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "CartItemDetail")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CartItemDetail {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(name = "amount")
    private int amount;

    //Tạo quan hệ
    @ManyToOne
    @JoinColumn(name = "cartItem_id")
    private CartItem cartItem;

    @ManyToOne
    @JoinColumn(name = "ProductDetailId")
    private ProductDetail ProductDetail;
}
