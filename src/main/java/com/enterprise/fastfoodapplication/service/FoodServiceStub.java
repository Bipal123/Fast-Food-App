package com.enterprise.fastfoodapplication.service;

import com.enterprise.fastfoodapplication.dao.IFoodDao;
import com.enterprise.fastfoodapplication.dto.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodServiceStub implements IFoodService {

    @Autowired
    private IFoodDao foodDao;

    public FoodServiceStub() {

    }

    public FoodServiceStub(IFoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @Override
    public Food getFoodItemById(int id) throws Exception {
        return foodDao.getFoodItemById(id);
    }

    @Override
    public List<Food> getAllFoodItems(String searchTerm) throws Exception {
        return foodDao.getAllFoodItems();
    }

    @Override
    public Food createFoodItem(Food food) throws  Exception{
        return foodDao.createFoodItem(food);
    }

    @Override
    public Food updateFoodItem(int id, Food food) throws Exception {
        return foodDao.updateFoodItem(id, food);
    }

    @Override
    public void removeFoodItem(int id) throws Exception {
        foodDao.removeFoodItem(id);
    }
}
