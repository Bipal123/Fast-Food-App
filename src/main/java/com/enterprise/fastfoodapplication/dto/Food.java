package com.enterprise.fastfoodapplication.dto;

import lombok.Data;
import com.google.gson.annotations.SerializedName;

public @Data
class Food {
    @SerializedName("id")
    private int foodId;
    @SerializedName("foodName")
    private String foodName;
    @SerializedName("foodCategory")
    private String foodCategory;
    @SerializedName("foodDescription")
    private String foodDescription;
    @SerializedName("foodPrice")
    private double foodPrice;
    //Might need to create another class for this based off of what the professor has done in his project
    //private MultipartFile foodImage;

}
