package GwenShop.com.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "review")
public class Review implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "review_text")
    private String review_text;
    @Column(name ="create_at")
    private Date create_at;

    //Tạo quan hệ
    @ManyToOne
    @JoinColumn(name = "userID")
    private Users user;
    @ManyToOne
    @JoinColumn(name = "prodID")
    private Product product;

    public Review AddReview(){
        List<Review> reviews = this.user.getReviews();
        reviews.add(this);
        this.user.setReviews(reviews);

        reviews = this.product.getReviews();
        reviews.add(this);
        this.product.setReviews(reviews);
        return this;
    }

    public Review RemoveReview(){
        List<Review> reviews = this.user.getReviews();
        reviews.remove(this);
        this.user.setReviews(reviews);

        reviews = this.product.getReviews();
        reviews.remove(this);
        this.product.setReviews(reviews);
        return this;
    }

}
