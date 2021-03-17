package com.example.product.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;



@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 30, message = "Please fill out from 2 to 30 characters ! ")
    private String name;

    @Min(value = 5, message = "Please fill out minimum 5$")
    private double price;

    @ManyToOne
    private Category category;

    @NotEmpty(message = "Please fill out description")
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone="Asia/Hanoi")
    private LocalDateTime datetime;

    @Min(value = 1, message = "Please fill out minimum 1 quantity")
    private int quantity;


    public Product() {
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Product(Long id, @Size(min = 2, max = 30, message = "Please fill out from 2 to 30 characters ! ") String name, @Min(value = 5, message = "Please fill out minimum 5$") double price, Category category, @NotEmpty(message = "Please fill out description") String description, LocalDateTime datetime, @Min(value = 1, message = "Please fill out minimum 1 quantity") int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.datetime = datetime;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
