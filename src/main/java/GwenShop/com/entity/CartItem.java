package GwenShop.com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="CartItem")
public class CartItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="amount")
    private int amount;

    //Tạo quan hệ bảng Many to one
    @ManyToOne
    @JoinColumn(name="CartId")
    private Cart cart;

    @OneToOne
    @JoinColumn(name="productId")
    private Product product;

    //Constructor
    public CartItem() {}


    //Getter - Setter
    public int getId() { return id;}

    public void setId(int id) {this.id = id;}

    public int getAmount() {return amount;}

    public void setAmount(int amount) {this.amount = amount;}

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
