package GwenShop.com.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vw_customer")
public class Customer implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "email")
    private String email;
    @Column(name = "passwd")
    private String passwd;
    @Column(name = "addr")
    private String addr;
    @Column(name = "phonenumber")
    private String phonenumber;
    @Column(name = "create_at")
    private String create_at;
    @Column(name = "delete_at")
    private String delete_at;


    public Customer(String fullname, String email, String passwd, String addr, String phonenumber, String roles, String create_at, String delete_at) {
        this.fullname = fullname;
        this.email = email;
        this.passwd = passwd;
        this.addr = addr;
        this.phonenumber = phonenumber;
        this.create_at = create_at;
        this.delete_at = delete_at;
    }

    public Customer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getDelete_at() {
        return delete_at;
    }

    public void setDelete_at(String delete_at) {
        this.delete_at = delete_at;
    }
}
