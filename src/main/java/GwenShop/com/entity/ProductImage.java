package GwenShop.com.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ProductImage")
@Getter
@Setter
public class ProductImage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "prod_image")
    private String image;

    //Tạo quan hệ
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    //Constructor
    public ProductImage() {}
}
