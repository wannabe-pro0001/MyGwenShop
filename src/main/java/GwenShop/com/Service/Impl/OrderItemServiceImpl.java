package GwenShop.com.Service.Impl;



import GwenShop.com.DAO.IOrderItemDao;
import GwenShop.com.DAO.Impl.OrderItemDaoImpl;
import GwenShop.com.Service.IOrderItemService;
import GwenShop.com.entity.*;
import GwenShop.com.entity.CompositeKey.OrderItemId;

import java.util.List;

public class OrderItemServiceImpl implements IOrderItemService {
    IOrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Override
    public void insert(OrderItem orderItem) {
        orderItemDao.insert(orderItem);
    }

    @Override
    public void delete(OrderItemId orderItemId) throws Exception {
        orderItemDao.delete(orderItemId);
    }

    @Override
    public OrderItem findById(int id) {
        return orderItemDao.findById(id);
    }

    @Override
    public List<OrderItem> findByOrder(Order orders) {
        return orderItemDao.findByOrder(orders);
    }

}
