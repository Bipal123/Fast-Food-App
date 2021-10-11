package com.enterprise.fastfoodapplication.dao;

import com.enterprise.fastfoodapplication.dto.Food;

import java.util.List;

public interface IFoodDao {
    Food createFoodItem(Food food) throws Exception;

    Food getFoodItemById(int id) throws Exception;

    List<Food> getAllFoodItems() throws Exception;

    Food updateFoodItem(int id, Food food) throws Exception;

    void removeFoodItem(int id) throws Exception;
}
