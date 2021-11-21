package com.enterprise.fastfoodapplication.dto;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    /** We might not need this to be honest, I can't think of adding this to our database
     * and don't see a reason as to why we'd need this id honestly
     */
    private String shoppingId;
    private Map<String, Order> orders; //We can probably use foodId as key in this Map object

    public ShoppingCart() {
        orders = new HashMap<String, Order>();
    }

    public ShoppingCart(String shoppingId) {
        this.shoppingId = shoppingId;
        orders = new HashMap<String, Order>();
    }

    public double totalEstimatedCostOfEntireCart()
    {
        double estimatedTotal = 0;
        for (Order order : orders.values()) {
            estimatedTotal += order.getFood().getFoodPrice()*order.getFoodQuantity();
        }
        return estimatedTotal;
    }

    /**
     * Returns details of a order for a given cart based on its foodId
     * @param foodId a unique identifier to represent a Food object
     * @return a Order object which contains food details and its quantity for this cart
     */
    public Order getOrderDetailsInCart(String foodId) {
        //TO DO Implementation
        return null;
    }

    /**
     * To add or update an order to your cart. If the food item exists, then update quantity. Otherwise, add
     * a new order in the orders HashMap
     * @param order takes a Order object containing food information and its quantity
     */
    public void addOrUpdateOrderToCart(Order order) {
        String cartOrderFoodId = Integer.toString(order.getFood().getFoodId());
        if(orders.containsKey(cartOrderFoodId)){
            Order currentOrder=orders.get(cartOrderFoodId);
            currentOrder.setFoodQuantity(currentOrder.getFoodQuantity()+order.getFoodQuantity());
            orders.put(cartOrderFoodId,currentOrder);
        }
        else{
            orders.put(cartOrderFoodId, order);
        }
    }

    public void removeOrderFromCart (Order order) {
        String cartOrderFoodId = Integer.toString(order.getFood().getFoodId());
        orders.remove(cartOrderFoodId);
    }
}
