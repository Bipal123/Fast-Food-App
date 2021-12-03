package com.enterprise.fastfoodapplication.service;

import com.enterprise.fastfoodapplication.dto.Food;
import com.enterprise.fastfoodapplication.dto.OrderHistory;

import java.util.List;

public interface IOrderService {
    OrderHistory saveOrder(OrderHistory order) throws Exception;

    List<OrderHistory> getAllOrders();
}
