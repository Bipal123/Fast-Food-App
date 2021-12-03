package com.enterprise.fastfoodapplication.dao;

import com.enterprise.fastfoodapplication.dto.OrderHistory;

import java.util.List;

public interface IOrderDao {
    OrderHistory saveOrder(OrderHistory order) throws Exception;

    List<OrderHistory> getAllOrders();
}
