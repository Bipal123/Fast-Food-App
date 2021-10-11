package com.enterprise.fastfoodapplication;

import com.enterprise.fastfoodapplication.dao.IFoodDao;
import com.enterprise.fastfoodapplication.dto.Food;
import com.enterprise.fastfoodapplication.service.FoodServiceStub;
import com.enterprise.fastfoodapplication.service.IFoodService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
class FastFoodApplicationTests {
    @Autowired
    private IFoodService foodService;
    private Food food = new Food();

    @MockBean
    private IFoodDao foodDao;

    @Test
    void contextLoads() {
    }

    @Test
    void getFoodItemById_returnsItalianPizzaForID9() throws Exception {
        givenFoodsDataAreAvailable();
        whenSearchFoodWithID9();
        thenReturnOneItalianPizzaFoodForID9();
    }

    private void givenFoodsDataAreAvailable() throws Exception {
        Mockito.when(foodDao.createFoodItem(food)).thenReturn(food);
        foodService = new FoodServiceStub(foodDao);
    }

    private void whenSearchFoodWithID9() {
        food = foodService.getFoodItemById(9);
    }

    private void thenReturnOneItalianPizzaFoodForID9() {
        String foodName = food.getFoodName();
        assertEquals("Italian Pizza", foodName);
    }

    @Test
    void createFood_validateReturnFoodWithFoodNameFoodCategoryAndFoodPrice() throws Exception {
        givenFoodsDataAreAvailable();
        whenUserCreatesANewFoodAndSaves();
        thenCreateNewFoodRecordAndReturnIt();
    }

    private void whenUserCreatesANewFoodAndSaves() {
        food.setFoodName("Chicken Burger");
        food.setFoodCategory("Snacks");
        food.setFoodPrice(12.99);
    }

    private void thenCreateNewFoodRecordAndReturnIt() throws  Exception{
        foodService.createFoodItem(food);
        Food createdFood = foodService.getFoodItemById(Integer.parseInt(food.getFoodId()));
        assertEquals(food, createdFood);
        verify(foodDao, atLeastOnce()).createFoodItem(food);
    }

}
