package ru.geekbrains.spring.context.lesson2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;


public class Product implements Serializable {

    private Long id;

    private String title;

    private BigDecimal cost;

    public Product() {
    }

    public Product(Long id, String title, BigDecimal cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.00");
        return String.format("Product: [%d %s %d]", id, title, cost.intValue());
    }
}