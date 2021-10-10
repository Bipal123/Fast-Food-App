package com.enterprise.fastfoodapplication;

import com.enterprise.fastfoodapplication.dto.Food;
import com.enterprise.fastfoodapplication.service.IFoodService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FastFoodApplicationTests {

    private IFoodService foodService;
    private  Food food = new Food();

    @Test
    void contextLoads() {
    }

    @Test
    void updateFoodDataWithChickenBurger(){
        givenFoodDataIsAvailable();
        whenUserSpecifiesCategorySnacks();
        whenUserSpecifiesPriceTwelveNinetyNine();
        thenAddChickenBurgerToFoodData();
    }

    private void givenFoodDataIsAvailable() {
        food.setFoodName("ChickenBurger");
        food.setFoodCategory("Snacks");
        food.setFoodPrice(12.99);
    }

    private void whenUserSpecifiesCategorySnacks() {
        assertEquals("Snacks",food.getFoodCategory());
    }

    private void whenUserSpecifiesPriceTwelveNinetyNine() {
        assertEquals(12.99,food.getFoodPrice());
    }

    private void thenAddChickenBurgerToFoodData() {

        foodService.createFoodItem(food);
    }
}
