package GwenShop.com.entity;

import lombok.*;

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
    @ManyToOne
    @JoinColumn(name="userId")
    private Users user;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;

    public Cart(Users user){
        this.user = user;
    }
}
