package com.enterprise.fastfoodapplication.controllers;

import com.enterprise.fastfoodapplication.dto.Food;
import com.enterprise.fastfoodapplication.dto.OrderHistory;
import com.enterprise.fastfoodapplication.dto.Photo;
import com.enterprise.fastfoodapplication.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The controller for Fast Food Application food items REST endpoints and web UI
 * <p>
 * This class handles the CRUD operations for Fast Food Application food items, via HTTP actions.
 * </p>
 * <p>
 * This class also serves HTML based web pages, for UI interactions with Food Items.
 * </p>
 * @author Bipal Goyal
 */
@Controller
public class FoodController {

    private static final Logger logger = Logger.getLogger(String.valueOf(FoodController.class));

    @Autowired
    IFoodService foodService;

    /**
     * This is for search bar on the navigation bar.
     * This happens when the user click "search".
     * */
    @GetMapping("/SearchFood")
    public ResponseEntity searchFood(@RequestParam(value="searchTerm",required = false,defaultValue = "None") String searchTerm){
        String newSearchTerm = searchTerm + "";
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     *This is for fetch, post and delete.
     *
     * */
    @GetMapping("/Food")
    public ResponseEntity fetchAllFood(){
        try {
            List<Food> allFood = foodService.getAllFoodItems();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity(allFood, headers, HttpStatus.OK);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Failed to fetch all food items", e);
            return  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Fetch a food object with the given ID.
     *
     * Given the parameter id, find a specimen that corresponds to this unique ID.
     *
     * Returns one of the following status codes:
     * 200: food found
     * 400: food not found
     *
     * @param id a unique identifier for this food
     */
    @GetMapping("/Food/{id}/")
    public ResponseEntity fetchFoodById(@PathVariable("id") int id){
        try {
            Food foundFood = foodService.getFoodItemById(id);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity(foundFood, headers, HttpStatus.OK);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Failed to fetch food item of id: " + Integer.toString(id), e);
            return  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            /*TO DO Logging*/
        }
    }

    /**
     * Create a new Food object, given the data provided.
     *
     * returns one of the following status codes:
     * 201: successfully created a new food.
     * 409: unable to create a food, because it already exists.
     *
     * @param food a JSON representation of a food object.
     * @return the newly created food object.
     */
    @PostMapping(value="/Food", consumes ="application/json", produces = "application/json")
    public ResponseEntity createFood(@RequestBody Food food){
        try {
            Food createdFood = foodService.createFoodItem(food);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity(createdFood, headers, HttpStatus.OK);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Failed to create food item", e);
            return  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Updates an existing Food object, given the data provided.
     *
     * returns one of the following status codes:
     * 201: successfully updated a new food.
     *
     * @param food a JSON representation of a food object.
     * @param id represents the id of the food object to be updated.
     * @return the newly created food object.
     */
    @PostMapping(value="/Food/{id}/", consumes ="application/json", produces = "application/json")
    public ResponseEntity updateFood(@PathVariable("id") int id, @RequestBody Food food){
        try {
            Food updateFoodItem = foodService.updateFoodItem(id, food);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity(updateFoodItem, headers, HttpStatus.OK);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Failed to update food item", e);
            return  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/Food/{id}/")
    public ResponseEntity removeFood(@PathVariable("id") int id){
        try {
            foodService.removeFoodItem(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Failed to delete food item of id: " + Integer.toString(id) , e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/createFoodForm")
    public String createFoodForm(Model model) {
        Food food = new Food();
        model.addAttribute(food);
        return "createFood";
    }


    @PostMapping("/saveFood")
    public ModelAndView saveFood(Food food, @RequestParam("imageFile") MultipartFile imageFile, Model model) {
        String returnValue = "createFood";
        ModelAndView modelAndView = new ModelAndView();
        try {
            foodService.createFoodItem(food);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.setViewName("error");
            return modelAndView;
        }

        Photo photo = new Photo();
        try {
            photo.setFileName(imageFile.getOriginalFilename());
            photo.setFood(food);
            foodService.saveImage(imageFile, photo);
            model.addAttribute("food", food);
            modelAndView.setViewName("success");
        } catch (IOException e) {
            e.printStackTrace();
            modelAndView.setViewName("error");
            return modelAndView;
        }
        return modelAndView;
    }
}
