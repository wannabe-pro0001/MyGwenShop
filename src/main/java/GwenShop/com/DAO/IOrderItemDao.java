package GwenShop.com.DAO;
import GwenShop.com.entity.*;
import GwenShop.com.entity.CompositeKey.OrderItemId;

import java.util.List;

public interface IOrderItemDao {
    public void insert(OrderItem orderItem);
    public void delete(OrderItemId orderItemId) throws Exception;
    public OrderItem findById(int id);
    public List<OrderItem> findByOrder (Order orders);
}
