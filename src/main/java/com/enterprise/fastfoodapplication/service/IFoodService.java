package com.enterprise.fastfoodapplication.service;

import com.enterprise.fastfoodapplication.dto.Food;
import com.enterprise.fastfoodapplication.dto.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * This interface (when implemented) will allow us to manage Food items by providing CRUD operations that update the
 * Food table in the database. The CRUD operations will be called when Administrators of the website will be logged in
 * while Read operation will be used in the front-end side for the customers.
 */
public interface IFoodService {

    /**
     * This method is used to retrieve Food details with foodId == id. The id will probably be passed as a
     * GET request through an endpoint or through URL routes directly for the front end of the website.
     * @param id It is a string (maybe int?) that is compared with foodId
     * @return A Food object containing the details of the food item if found in database, otherwise return NULL
     */
    Food getFoodItemById(int id) throws Exception;

    /**
     * This method is used to return a List of all the food items that exist within the database. Return NULL
     * if food Table is empty in database.
     * @return a List of food objects.
     */
    List<Food> getAllFoodItems() throws Exception;

    /**
     * This method invokes another method within the DAO (persistence) package and save the Food item
     * to the database.
     * @param food This is a Food object containing details that will be saved in the db.
     * @return Returns the created Food Object
     */
    Food createFoodItem(Food food) throws Exception;

    /**
     * This method is used to update details about an existing food Item based off of its foodId value.
     * We probably need to invoke a edit operation within the persistence layer and pass it a Food object as
     * our parameter. Throw exception if there is no food with foodId == id.
     * @param id It is a int that is compared with foodId
     * @return updated food item
     */
    Food updateFoodItem(int id, Food food) throws Exception;

    /** This method is used to remove an existing food Item based off of its foodId value.
     * We probably need to invoke a delete operation within the persistence layer and pass it id as our parameter.
     * Throw exception if there is no food with foodId == id.
     * @param id It is an int that is compared with foodId
     */
    void removeFoodItem(int id) throws Exception;

    /** This method is used to upload an image and save its information in Photo entity.
     * @param imageFile the image to be uploaded
     * @param photo the object on which to save image
     */
    void saveImage(MultipartFile imageFile, Photo photo) throws IOException;

}
