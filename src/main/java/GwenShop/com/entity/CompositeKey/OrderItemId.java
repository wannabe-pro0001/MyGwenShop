package GwenShop.com.entity.CompositeKey;

import GwenShop.com.entity.Order;
import GwenShop.com.entity.Product;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
public class OrderItemId implements Serializable {
    private Order order;
    private Product product;

    //Constructor
    public OrderItemId(Order orderID, Product prodID){
        this.order = orderID;
        this.product = prodID;
    }

    //Equal() HashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemId)) return false;
        OrderItemId that = (OrderItemId) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
