package GwenShop.com.Service;

import GwenShop.com.entity.Order;

import java.util.List;

public interface IOrderService {
    public Order findbyId (int id);
    public List<Order> findbyUserId (int id);
    public void insert (Order order);
    public void update (Order order);
    public void delete (Order order) throws Exception;
}