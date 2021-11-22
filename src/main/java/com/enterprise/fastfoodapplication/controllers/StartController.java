package com.enterprise.fastfoodapplication.controllers;
import com.enterprise.fastfoodapplication.dto.OrderHistory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller


public class StartController {
    @GetMapping("/start")
    public String getStart(){
        return "start";
    }

    @RequestMapping("/")
    public String index(Model model) {
        /*
          Need an orderHistory class to store the name and number of Items a customer ordered.
          This happens when the user click "check out".
          The "check out" button act like a "save" button to store the information of order in OrderHistory class.
          */
        OrderHistory orderHistory= new OrderHistory();
        orderHistory.setFoodAmount(2);
        orderHistory.setFoodName("burger");
        model.addAttribute(orderHistory);
        return "start";
    }
}

