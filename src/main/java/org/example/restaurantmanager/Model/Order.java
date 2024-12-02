package org.example.restaurantmanager.Model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author DOAN VY VY on 12/1/2024
 */
@Setter
@Getter
public class Order {
    // Getters and setters
    private Long id;
    private String dishName;
    private int quantity;
    private String status;
    private String priority;
    private LocalDateTime createdAt;

    // Constructors
    public Order() {
        this.createdAt = LocalDateTime.now();
    }

    public Order(Long id, String dishName, int quantity, String priority) {
        this.id = id;
        this.dishName = dishName;
        this.quantity = quantity;
        this.status = "pending";
        this.priority = priority;
        this.createdAt = LocalDateTime.now();
    }

}