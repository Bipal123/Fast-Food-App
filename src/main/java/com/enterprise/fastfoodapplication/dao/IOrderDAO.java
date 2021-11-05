package com.enterprise.fastfoodapplication.dao;

import com.enterprise.fastfoodapplication.dto.Food;

import java.util.List;

public interface IOrderDAO {
    Food createOrder(Food food) throws Exception;

    Food getOrderId(int id) throws Exception;

    List<Food> getAllOrders() throws Exception;

    Food updateOrders(int id, Food food) throws Exception;

    void removeOrders(int id) throws Exception;
}
