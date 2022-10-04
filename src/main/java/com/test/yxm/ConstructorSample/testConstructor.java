package com.test.yxm.ConstructorSample;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class testConstructor {

    public static void main(String[] args) {

        try {
            Class employeeClass = Class.forName("com.test.yxm.ConstructorSample.Employee");
            Constructor constructor = employeeClass.getConstructor(new Class[]{Integer.class, String.class, Float.class, String.class});
            Employee employee = (Employee) constructor.newInstance(new Object[]{
                100, "张三", 100f, "开发部"
            });
            System.out.println(employee);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
