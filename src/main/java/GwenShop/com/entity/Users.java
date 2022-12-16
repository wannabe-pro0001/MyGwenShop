package GwenShop.com.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Users")
@NamedQuery(name="Users.findAll", query = "SELECT u FROM Users u")
@Getter
@Setter
@NoArgsConstructor
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "passwd")
    private String passwd;

    @Column(name = "addr")
    private String addr;

    @Column(name = "phoneNo")
    private String phoneNumber;

    @Column(name = "salary")
    private int salary;

    @Column(name = "roles")
    private int roles;

    @Column(name = "create_at")
    private Date create_at;

    //Tạo quan hệ
    @OneToOne(mappedBy = "user")
    private Cart carts;

    @OneToMany(mappedBy = "user")
    private List<WishListItem> wishListItems;

    @OneToMany(mappedBy="user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "emp_id")
    private List<Blog> blogs;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany(mappedBy = "employee")
    private List<Order> VerifiedOrders;

    //
    public WishListItem AddWishList(Product product){
        WishListItem item = new WishListItem();
        item.setUser(this);
        item.setProduct(product);
        wishListItems.add(item);
        return item;
    }

    public WishListItem RemoveWishList(WishListItem item){
        wishListItems.remove(item);
        return item;
    }
}