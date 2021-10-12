package com.enterprise.fastfoodapplication;

import com.enterprise.fastfoodapplication.dto.Food;
import com.enterprise.fastfoodapplication.dto.OrderHistory;
import com.enterprise.fastfoodapplication.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
public class FastFoodController {

    private static final Logger logger = Logger.getLogger("com.enterprise.fastfoodapplication.FastFoodController");


    IFoodService foodService;

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
            e.printStackTrace();
            return  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            /*TO DO Logging*/
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
            e.printStackTrace();
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
            e.printStackTrace();
            logger.log(Level.WARNING, "Failed to create food item");
            return  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            /*TO DO Logging*/
        }
    }

    @PostMapping(value="/Food/{id}/", consumes ="application/json", produces = "application/json")
    public ResponseEntity updateFood(@PathVariable("id") int id, @RequestBody Food food){
        try {
            Food updateFoodItem = foodService.updateFoodItem(id, food);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity(updateFoodItem, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.WARNING, "Failed to create food item");
            return  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            /*TO DO Logging*/
        }
    }

    @DeleteMapping("/Food/{id}/")
    public ResponseEntity removeFood(@PathVariable("id") String id){
        try {
            foodService.removeFoodItem(Integer.parseInt(id));
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            /*TO DO Logging*/
        }
    }
}
