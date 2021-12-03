package com.enterprise.fastfoodapplication.controllers;
import com.enterprise.fastfoodapplication.dto.Food;
import com.enterprise.fastfoodapplication.dto.OrderHistory;
import com.enterprise.fastfoodapplication.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller


public class OrdersController {
    @Autowired
    IOrderService orderService;

    @GetMapping("/orders")
    public ModelAndView getOrder(Model model){
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<OrderHistory> orders = orderService.getAllOrders();
            modelAndView.addObject("orders", orders);
        }
        catch (Exception e) {
            modelAndView.setViewName("error");
            return modelAndView;
        }
        modelAndView.setViewName("Orders");
        return  modelAndView;
    }

    @PostMapping("/saveOrder")
    public ModelAndView saveOrder(OrderHistory order, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            orderService.saveOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.setViewName("error");
            return modelAndView;
        }
        modelAndView.setViewName("success");
        return modelAndView;
    }
}

