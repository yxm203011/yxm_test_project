package com.test.yxm.ConstructorSample;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class methodSample {
    public static void main(String[] args) {
        try {
            Class employeeClass = Class.forName("com.test.yxm.ConstructorSample.Employee");
            Constructor constructor = employeeClass.getConstructor(new Class[]{Integer.class, String.class, Float.class, String.class});
            Employee employee = (Employee) constructor.newInstance(new Object[]{100, "张三", 100f, "研发部"});
            Method updateSalary = employeeClass.getMethod("updateSalary", Float.class);
            Employee employee1 = (Employee)updateSalary.invoke(employee, new Object[]{100f});
            System.out.println(employee1);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
