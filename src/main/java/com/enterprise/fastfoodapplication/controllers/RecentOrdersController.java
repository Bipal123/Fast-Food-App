package com.enterprise.fastfoodapplication.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller


public class RecentOrdersController {
    @GetMapping("/recentorders")
    public String getRecentOrders(){
        return "RecentOrders";
    }
}

