package com.enterprise.fastfoodapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @GetMapping("/recentorders")
    public String getRecentOrders(){
        return "RecentOrders";
    }

    @GetMapping("/shoppingcart")
    public String getShoppingCart(){
        return "ShoppingCart";
    }
}
