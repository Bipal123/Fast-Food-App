package com.enterprise.fastfoodapplication.dao;

import com.enterprise.fastfoodapplication.dto.CartOrder;

import java.util.HashMap;
import java.util.Map;
import com.enterprise.fastfoodapplication.dto.ShopperDTO;
public class CartOrderDAO {

    ShopperDTO shopper = new ShopperDTO();
    private Map<String, CartOrder> orders; //We can probably use foodId as key in this Map object

    public Map<String, CartOrder> ShoppingCart() {
        orders = new HashMap<String, CartOrder>();
    return orders;
    }
    public double totalEstimatedCostOfEntireCart()
    {
        double estimatedTotal = 0;
        for (CartOrder order : orders.values()) {
            estimatedTotal += order.getFood().getFoodPrice()*order.getFoodQuantity();
        }
        return estimatedTotal;
    }
    public CartOrder getOrderDetailsInCart(String foodId) {
        //TO DO Implementation
        return null;
    }
    public void addOrUpdateOrderToCart(CartOrder order) {
        String cartOrderFoodId = Integer.toString(order.getFood().getFoodId());
        if(orders.containsKey(cartOrderFoodId)){
            CartOrder currentOrder=orders.get(cartOrderFoodId);
            currentOrder.setFoodQuantity(currentOrder.getFoodQuantity()+order.getFoodQuantity());
            orders.put(cartOrderFoodId,currentOrder);
        }
        else{
            orders.put(cartOrderFoodId, order);
        }
    }
    public void removeOrderFromCart (CartOrder order) {
        String cartOrderFoodId = Integer.toString(order.getFood().getFoodId());
        orders.remove(cartOrderFoodId);
    }
}

