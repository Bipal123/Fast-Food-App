package com.enterprise.fastfoodapplication.dao;

import com.enterprise.fastfoodapplication.dto.Food;
import com.enterprise.fastfoodapplication.dto.OrderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderSQLDao implements IOrderDao{
    @Autowired
    OrderRepository orderRepository;
    @Override
    public OrderHistory saveOrder(OrderHistory order) throws Exception {
        if (orderRepository.existsById(order.getOrderId())) {
            throw new Exception("Order already exists with id: " + order.getOrderId());
        }
        OrderHistory createdOrder = orderRepository.save(order);
        return createdOrder;
    }

    @Override
    public List<OrderHistory> getAllOrders() {
        List<OrderHistory> ordersList = new ArrayList<>();
        Iterable<OrderHistory> orders = orderRepository.findAll();
        for (OrderHistory order : orders) {
            ordersList.add(order);
        }
        return ordersList;
    }
}
