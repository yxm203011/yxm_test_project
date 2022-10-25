package com.yxm.spring.ioc.bookshop.dao;

public class BookDaoImpl implements BookDao{

    @Override
    public void insert() {
        System.out.println("向数据库插入数据");
    }
}
