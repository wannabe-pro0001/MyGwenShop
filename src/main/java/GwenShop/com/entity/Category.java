package GwenShop.com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "vw_category")
@NamedQuery(name="Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "category_name")
    private String name;
    @Column(name = "amount")
    private int amount;
    @Column(name = "delete_at")
    private String delete_at;

    //Tạo quan hệ
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    //Constructor
    public Category(String name, int amount, String delete_at) {
        this.name = name;
        this.amount = amount;
        this.delete_at = delete_at;
    }

    public Category() {

    }

    //Getter - Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDelete_at() {
        return delete_at;
    }

    public void setDelete_at(String delete_at) {
        this.delete_at = delete_at;
    }
}
