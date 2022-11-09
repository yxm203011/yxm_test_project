package com.yxm.spring.aop.bookshop.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Company {
    private List<String> rooms;
    private Map<String,Computer> computerMap;
    private Properties info;



    public List<String> getRooms() {
        return rooms;
    }

    public void setRooms(List<String> rooms) {
        System.out.println("调用SetRooms方法");
        this.rooms = rooms;
    }

    public Map<String, Computer> getComputerMap() {
        return computerMap;
    }

    public void setComputerMap(Map<String, Computer> computerMap) {
        this.computerMap = computerMap;
    }

    public Properties getInfo() {
        return info;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Company{" +
                "rooms=" + rooms +
                ", computerMap=" + computerMap +
                ", info=" + info +
                '}';
    }
}
