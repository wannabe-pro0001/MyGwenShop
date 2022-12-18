package GwenShop.com.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Cart")
@Getter
@Setter
@NoArgsConstructor
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /* Tạo quan hệ */
    @OneToOne
    @JoinColumn(name="userId")
    private Users user;

    @OneToMany(mappedBy = "cart")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<CartItem> cartItems;

    public Cart(Users user){
        this.user = user;
    }

    public CartItem addCartItem (CartItem cartItem){
        getCartItems().add(cartItem);
        cartItem.setCart(this);
        return cartItem;
    }
}
