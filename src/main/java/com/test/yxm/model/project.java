package com.test.yxm.model;

import java.math.BigDecimal;

public class project {
    private int id;

    private String color;

    private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "project{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
