package com.enterprise.fastfoodapplication.service;

import com.enterprise.fastfoodapplication.dao.IFoodDao;
import com.enterprise.fastfoodapplication.dao.IOrderDao;
import com.enterprise.fastfoodapplication.dto.OrderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService implements IOrderService{
    @Autowired
    private IOrderDao orderDao;
    @Override
    public OrderHistory saveOrder(OrderHistory order) throws Exception {
        return orderDao.saveOrder(order);
    }

    @Override
    public List<OrderHistory> getAllOrders() {
        return orderDao.getAllOrders();
    }
}
