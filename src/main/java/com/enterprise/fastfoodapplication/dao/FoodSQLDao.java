package com.enterprise.fastfoodapplication.dao;

import com.enterprise.fastfoodapplication.dto.Food;
import org.apache.tomcat.jni.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("foodDao")
public class FoodSQLDao implements IFoodDao {

    @Autowired
    FoodRepository foodRepository;

    @Override
    public Food createFoodItem(Food food) throws Exception {
        if (foodRepository.existsById(food.getFoodId())) {
            throw new Exception("Food already exists with id: " + food.getFoodId());
        }
        Food createdFood = foodRepository.save(food);
        return createdFood;
    }

    @Override
    public Food getFoodItemById(int id) throws Exception {
        return foodRepository.findById(id).get();
    }

    @Override
    public List<Food> getAllFoodItems() throws Exception {
        List<Food> foodList = new ArrayList<>();
        Iterable<Food> foods = foodRepository.findAll();
        for (Food food: foods) {
            foodList.add(food);
        }
        return foodList;
    }

    @Override
    public Food updateFoodItem(int id, Food food) throws Exception {
        if (foodRepository.existsById(id)) {
            food.setFoodId(id);
            Food updatedFood = foodRepository.save(food);
            return updatedFood;
        }
        else {
            throw new Exception("No food in database with id: " + id);
        }
    }

    @Override
    public void removeFoodItem(int id) throws Exception {
        foodRepository.deleteById(id);
    }
}
