package com.test.yxm.ConstructorSample;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class fieldSample {
    public static void main(String[] args) {
        try {
            Class employeeClass = Class.forName("com.test.yxm.ConstructorSample.Employee");
            Constructor constructor = employeeClass.getConstructor(new Class[]{Integer.class, String.class, Float.class, String.class});
            Employee employee = (Employee) constructor.newInstance(new Object[]{
                    100, "张三", 1000f, "研发部"
            });
            Field eNameField = employeeClass.getField("ename");
            eNameField.set(employee,"王五");
            String enameVal = (String) eNameField.get(employee);

            System.out.println(enameVal);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
