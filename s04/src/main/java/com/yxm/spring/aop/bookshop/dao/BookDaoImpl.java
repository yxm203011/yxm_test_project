package com.yxm.spring.aop.bookshop.dao;

public class BookDaoImpl implements BookDao{

    @Override
    public void insert() {
        System.out.println("向数据库插入数据");
    }
}
