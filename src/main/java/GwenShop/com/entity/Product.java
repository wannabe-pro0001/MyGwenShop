package GwenShop.com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")
@NamedQuery(name = "Product.findAll", query = "SELECT c FROM Product c")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "prod_description")
    private String description;
    @Column(name = "amount")
    private int amount;
    @Column(name = "hot_product")
    private int hot;
    @Column(name = "price")
    private int price;
    @Column(name = "delete_at")
    private String delete_id;

    //Tạo quan hệ
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<Product_Image> product_image;

    //Constructor
    public Product(){}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDelete_id() {
        return delete_id;
    }

    public void setDelete_id(String delete_id) {
        this.delete_id = delete_id;
    }

    public Category getCategory() {return category;}

    public void setCategory(Category category) {this.category = category;}

    public List<Product_Image> getProduct_image() {return product_image;}

    public void setProduct_image(List<Product_Image> product_image) {this.product_image = product_image;}
}
