package com.yxm.spring.aop.entity;

import java.util.List;

public class Chlid {

    private String name;

    private Apple apple;

    private List<Apple> appleList;

    public Chlid() {
    }

    public Chlid(String name, Apple apple) {
        this.name = name;
        this.apple = apple;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        System.out.println("child类调用Set方法");
        this.apple = apple;
    }
    public void eat(){
        System.out.println(name+"吃到了"+apple.getOrigin()+"种植的"+apple.getTitle());
    }

    public List<Apple> getAppleList() {
        return appleList;
    }

    public void setAppleList(List<Apple> appleList) {
        this.appleList = appleList;
    }
}
