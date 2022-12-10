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

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "salary")
    private int salary;

    @Column(name = "roles")
    private int roles;

    @Column(name = "create_at")
    private Date create_at;

    //Tạo quan hệ
    @OneToMany(mappedBy = "user")
    private List<Cart> carts;
}
