package com.enterprise.fastfoodapplication.controllers;
import com.enterprise.fastfoodapplication.dto.Food;
import com.enterprise.fastfoodapplication.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller


public class CategoryController {
    @Autowired
    private IFoodService iFoodservice;

    @GetMapping("/category")
    public String getCategory(Model model) throws Exception {
        List<Food> foodList = iFoodservice.getAllFoodItems();
        model.addAttribute("Food",foodList);
        return "Category";
    }
}
