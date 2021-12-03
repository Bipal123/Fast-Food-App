package com.enterprise.fastfoodapplication.dto;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="orders")
public @Data
 class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private int foodAmount;
    private String foodName;
}
