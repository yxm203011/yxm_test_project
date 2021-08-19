package com.test.yxm.junit.jdk18.entity;

import java.math.BigDecimal;

public class project {
    private String code;

    private String color;

    private String name;

    private BigDecimal price;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "code='" + code + '\'' +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
