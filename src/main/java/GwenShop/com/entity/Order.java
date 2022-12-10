package GwenShop.com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vw_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int userId;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "addr")
    private String address;
    @Column(name = "phonenumber")
    private String phonenumber;
    @Column(name = "statusOrder")
    private String status;
    @Column(name = "price")
    private int price;
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "create_at")
    private String create_at;

    //   id, userId, fullname, addr, phonenumber, statusOrder, price, employee_id, create_at
    public Order(int userId, String fullname, String address, String phonenumber, String status, int price, int employeeId, String create_at) {
        this.userId = userId;
        this.fullname = fullname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.status = status;
        this.price = price;
        this.employeeId = employeeId;
        this.create_at = create_at;
    }

    public Order() {

    }

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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
