package com.yxm.spring.aop.entity;

public class Apple {
    private String title;

    private String color;

    private String origin;

    private Float price;

    public Apple() {
        System.out.println("无参的构造方法！" + this);
    }

    public Apple(String title, String color, String origin) {
        System.out.println("有参的构造方法！" + this);
        this.title = title;
        this.color = color;
        this.origin = origin;
    }
    public Apple(String title, String color, String origin,Float price) {
        System.out.println("有参价格的构造方法！" + this);
        this.title = title;
        this.color = color;
        this.origin = origin;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
