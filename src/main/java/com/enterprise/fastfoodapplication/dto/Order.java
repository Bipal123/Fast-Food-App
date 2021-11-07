package com.enterprise.fastfoodapplication.dto;

import lombok.Data;

public @Data
class Order {

    public Order(){
    }

    public Order(Food food){
        this.food = food;
        this.foodQuantity = 1;
    }

    public Order(Food food, int foodQuantity) {
        this.food = food;
    }

    private String orderId;
    private Food food;
    private int foodQuantity;

    /**
     * To calculate the total cost for a particular food item in a cart
     * @return a double that tells you the total price for a line item in the cart
     */
    public double totalEstimatedCostOfFoodItem () {
        double estimatedTotal = food.getFoodPrice() * foodQuantity;
        return estimatedTotal;
    }

}
