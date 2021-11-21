package com.enterprise.fastfoodapplication.dao;

import com.enterprise.fastfoodapplication.dto.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("foodDao")
public class FoodSQLDao implements IFoodDao {

    @Autowired
    FoodRepository foodRepository;

    @Override
    public Food createFoodItem(Food food) throws Exception {
        Food createdFood = foodRepository.save(food);
        return createdFood;
    }

    @Override
    public Food getFoodItemById(int id) throws Exception {
        return null;
    }

    @Override
    public List<Food> getAllFoodItems() throws Exception {
        return null;
    }

    @Override
    public Food updateFoodItem(int id, Food food) throws Exception {
        return null;
    }

    @Override
    public void removeFoodItem(int id) throws Exception {

    }
}
