package GwenShop.com.entity;

import GwenShop.com.entity.CompositeKey.OrderItemId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "OrderItem")
@IdClass(OrderItemId.class)
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "amount")
    private int amount;

    //________
    @Id
    @ManyToOne
    @JoinColumn(name = "OrderId")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "ProdID")
    private Product product;
}
