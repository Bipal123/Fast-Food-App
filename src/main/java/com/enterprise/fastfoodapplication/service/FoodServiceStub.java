package com.enterprise.fastfoodapplication.service;

import com.enterprise.fastfoodapplication.dao.IFoodDao;
import com.enterprise.fastfoodapplication.dto.Food;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FoodServiceStub implements IFoodService {

    private IFoodDao foodDao;

    public FoodServiceStub() {

    }

    public FoodServiceStub(IFoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @Override
    public Food getFoodItemById(int id) {
        Food food = new Food();
        food.setFoodId("9");
        food.setFoodName("Italian Pizza");
        return food;
    }

    @Override
    public Map<String, Food> getAllFoodItems() {
        return null;
    }

    @Override
    public void createFoodItem(Food food){
    }

    @Override
    public void updateFoodItem(int id) {

    }

    @Override
    public void removeFoodItem(String id) {

    }
}
