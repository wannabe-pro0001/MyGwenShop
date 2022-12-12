package GwenShop.com.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "ProductSize")
@NoArgsConstructor
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String name;

    //Tạo quan hệ
    @ManyToOne
    @JoinColumn(name = "productID")
    private Product product;

    @OneToMany(mappedBy = "ProductSize")
    private List<wishListItem> wishListItem;
}
