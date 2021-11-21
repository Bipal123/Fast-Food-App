package com.enterprise.fastfoodapplication.dto;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public @Data
class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int foodId;

    private String foodName;
    private String foodCategory;
    private String foodDescription;
    private double foodPrice;
    //Might need to create another class for this based off of what the professor has done in his project
    //private MultipartFile foodImage;

}
