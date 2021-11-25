package com.enterprise.fastfoodapplication.service;

import com.enterprise.fastfoodapplication.dao.IFoodDao;
import com.enterprise.fastfoodapplication.dto.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodService implements IFoodService {

    @Autowired
    private IFoodDao foodDao;

    public FoodService() {

    }

    public FoodService(IFoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @Override
    @Cacheable(value="food", key="#id")
    public Food getFoodItemById(int id) throws Exception {
        return foodDao.getFoodItemById(id);
    }

    @Override
    @Cacheable("foods")
    public List<Food> getAllFoodItems() throws Exception {
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
    @CacheEvict(value="food", key="#id")
    public void removeFoodItem(int id) throws Exception {
        foodDao.removeFoodItem(id);
    }
}
