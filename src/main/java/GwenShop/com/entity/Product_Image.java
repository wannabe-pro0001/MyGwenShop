package GwenShop.com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_image")
public class Product_Image implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "prod_image")
    private String image;

    //Tạo quan hệ
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    //Constructor
    public Product_Image() {}

    //Getter - Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
