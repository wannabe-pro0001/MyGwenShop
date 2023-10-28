package GwenShop.com.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @Column(name = "roles")
    private int roles;
    @Column(name = "create_at")
    private String create_at;

    //Tạo quan hệ
    @OneToOne(mappedBy = "user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cart carts;

    @OneToMany(mappedBy = "user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<WishListItem> wishListItems;

    @OneToMany(mappedBy="user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "emp_id")
    private List<Blog> blogs;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany(mappedBy = "employee")
    private List<Order> VerifiedOrders;

    @PreRemove
    private void PreRemove(){
        reviews.forEach(review -> review.setUser(null));
        blogs.forEach(blog -> blog.setEmp_id(null));
        orders.forEach(order -> order.setUser(null));
        VerifiedOrders.forEach(order -> order.setUser(null));
    }

    public String GetLastName(){
        String name = fullName.trim();
        name = name.replaceAll("\\s+", " ");
        return name.substring(name.lastIndexOf(" ")+1);
    }
}