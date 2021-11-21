package com.enterprise.fastfoodapplication.dto;

import lombok.Data;

/*
Order class holds food and quantity
cartID - used to create order stub until submitted as order
orderID - populated when order is created. used for order history queries
* */

public @Data
class Order {

    private String orderId;
    private String cartId;
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
