package com.enterprise.fastfoodapplication.dao;

import com.enterprise.fastfoodapplication.dto.Food;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodDaoStub implements IFoodDao {

    Map<Integer, Food> allFoods = new HashMap<>();
    @Override
    public Food createFoodItem(Food food) {
        allFoods.put(food.getFoodId(), food);
        return food;
    }

    @Override
    public Food getFoodItemById(int id) {
        return allFoods.get(id);
    }

    @Override
    public List<Food> getAllFoodItems() {
        List<Food> allFoodsList = new ArrayList<>(allFoods.values());
        return  allFoodsList;
    }

    @Override
    public Food updateFoodItem(int id, Food food) {
        allFoods.put(food.getFoodId(), food);
        return food;
    }

    @Override
    public void removeFoodItem(int id) {
        allFoods.remove(id);
    }
}
