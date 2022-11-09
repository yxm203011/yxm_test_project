package com.yxm.spring.aop.bookshop.entity;

public class Computer {
    private String brand;

    private String type;

    private String sn;

    private Float price;

    public void insert(String name){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("添加方法"+name);
    }
    public String update(){
        return "修改";
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Computer() {
    }

    public Computer(String brand, String type, String sn, Float price) {
        this.brand = brand;
        this.type = type;
        this.sn = sn;
        this.price = price;
    }
}
