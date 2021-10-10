package com.enterprise.fastfoodapplication.dao;

import com.enterprise.fastfoodapplication.dto.Food;

public interface IFoodDao {
    Food createFoodItem(Food food) throws Exception;
}
