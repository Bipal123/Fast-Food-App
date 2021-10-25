package com.enterprise.fastfoodapplication.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller


public class CategoryController {
    @GetMapping("/category")
    public String getCategory(){
        return "Category";
    }
}
