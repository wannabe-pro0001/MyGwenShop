package GwenShop.com.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
@NoArgsConstructor
@NamedQuery(name = "Product.findAll", query = "SELECT c FROM Product c")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "prod_name")
    private String name;

    @Column(name = "prod_description")
    private String description;

    @Column(name = "amount")
    private int amount;

    @Column(name = "price")
    private int price;

    //Tạo quan hệ
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    private List<ProductImage> productImages;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    private List<ProductSize> productSizes;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    private List<Review> reviews;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    private List<WishListItem> wishListItems;
}
