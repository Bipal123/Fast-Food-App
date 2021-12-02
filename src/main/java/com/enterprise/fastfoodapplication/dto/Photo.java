package com.enterprise.fastfoodapplication.dto;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="photos")
public @Data
class Photo {

    @Id
    @GeneratedValue
    private int photoId;
    private String path;
    private String fileName;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="foodId")
    private Food food;
}
