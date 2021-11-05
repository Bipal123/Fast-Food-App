package com.enterprise.fastfoodapplication.dao;

import com.enterprise.fastfoodapplication.dto.Food;

import java.util.List;

public class IOrderDAOStub implements IOrderDAO {
    @Override
    public Food createOrder(Food food) throws Exception {
        return null;
    }

    @Override
    public Food getOrderId(int id) throws Exception {
        return null;
    }

    @Override
    public List<Food> getAllOrders() throws Exception {
        return null;
    }

    @Override
    public Food updateOrders(int id, Food food) throws Exception {
        return null;
    }

    @Override
    public void removeOrders(int id) throws Exception {

    }
}
