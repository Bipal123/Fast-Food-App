package com.enterprise.fastfoodapplication.service;

import com.enterprise.fastfoodapplication.dto.Food;
import com.enterprise.fastfoodapplication.dto.OrderHistory;

import java.util.List;

public interface IOrderService {
    /** Used to save an order object to the database
     * @param order the object to be saved
     * @return the saved order object in the database
     */
    OrderHistory saveOrder(OrderHistory order) throws Exception;

    /**
     * This method is used to return a List of all the orders that exist within the database. Return NULL
     * if order Table is empty in database.
     * @return a List of order objects.
     */
    List<OrderHistory> getAllOrders();
}
