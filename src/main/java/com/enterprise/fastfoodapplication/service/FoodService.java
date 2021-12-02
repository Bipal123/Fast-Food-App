package com.enterprise.fastfoodapplication.service;

import com.enterprise.fastfoodapplication.dao.IFoodDao;
import com.enterprise.fastfoodapplication.dao.IPhotoDAO;
import com.enterprise.fastfoodapplication.dto.Food;
import com.enterprise.fastfoodapplication.dto.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public class FoodService implements IFoodService {

    @Autowired
    private IFoodDao foodDao;

    @Autowired
    private IPhotoDAO photoDAO;

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

    @Override
    public void saveImage(MultipartFile imageFile, Photo photo) throws IOException {
        photoDAO.save(photo);
        photoDAO.saveImage(imageFile, photo);
    }
}
