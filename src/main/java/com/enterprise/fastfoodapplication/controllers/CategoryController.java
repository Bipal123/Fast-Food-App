package com.enterprise.fastfoodapplication.controllers;
import com.enterprise.fastfoodapplication.dto.Food;
import com.enterprise.fastfoodapplication.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller


public class CategoryController {
    @Autowired
    private IFoodService iFoodservice;

    @GetMapping("/category")
    public ModelAndView getCategory() throws Exception {
        ModelAndView modelAndView = new ModelAndView();

            modelAndView.setViewName("Category");
            List<Food> foods = iFoodservice.getAllFoodItems();
            modelAndView.addObject("foods", foods);
            return  modelAndView;

        /*
        catch (Exception e) {
            modelAndView.setViewName("error");
            return modelAndView;
        }*/
    }
}
