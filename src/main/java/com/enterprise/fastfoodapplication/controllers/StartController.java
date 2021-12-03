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
        return "start";
    }
}

