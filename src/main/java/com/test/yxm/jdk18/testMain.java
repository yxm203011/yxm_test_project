package com.test.yxm.jdk18;

import com.sun.deploy.net.MessageHeader;
import com.test.yxm.jdk18.entity.project;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class testMain {
    private static List<project> listProject = new ArrayList<>();

    static {
        for (int i = 1; i <= 10; i++) {
            project p = new project();
            p.setCode("code_" + i);
            p.setColor("color_" + i);
            p.setName("name_"+i);
            p.setPrice(new BigDecimal("0.0"+i));
            listProject.add(p);
        }
    }

    public static void main(String[] args) {
        listProject.stream().filter((p) -> p.getPrice().compareTo(new BigDecimal("0.02")) == 1).forEach(System.out::println);
    }


}
