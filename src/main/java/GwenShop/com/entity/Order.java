package GwenShop.com.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jboss.weld.executor.DaemonThreadFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.ObjDoubleConsumer;

@Entity
@Table(name = "Orders")
@Getter
@Setter
@NoArgsConstructor
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fullname")
    private String fullName;
    @Column(name = "addr")
    private String address;
    @Column(name = "phoneNo")
    private String phoneNumber;
    @Column(name = "statusOrder")
    private String status;
    @Column(name = "price")
    private int price;
    @Column(name = "create_at")
    private String create_at;

    //Tạo quan hệ
    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Users employee;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();
    public Order (String fullName, String address, String phoneNumber, int price, Users user){
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.status = "chờ xử lý";
        this.price = price;
        this.create_at = new Date().toString();
        this.user = user;
    }

    public OrderItem addOrderItem(OrderItem orderItem){
        getOrderItems().add(orderItem);
        orderItem.setOrder(this);
        return orderItem;
    }
}
