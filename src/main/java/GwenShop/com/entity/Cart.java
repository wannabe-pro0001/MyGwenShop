package GwenShop.com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Cart")
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "userId")
    private int userId;

    /* Tạo quan hệ many to one với users */

    @ManyToOne
    @JoinColumn(name="userId")
    private Users user;

    /* Constructor */
    public Cart() { }

    //Getter - Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
