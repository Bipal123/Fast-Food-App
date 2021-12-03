package com.enterprise.fastfoodapplication.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "food")
    private List<Photo> photos;
}
