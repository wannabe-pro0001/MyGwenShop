package GwenShop.com.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "wishListItem")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class wishListItem {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    //Tạo quan hệ
    @ManyToOne
    @JoinColumn(name = "userID")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "prodID")
    private Product product;
}
