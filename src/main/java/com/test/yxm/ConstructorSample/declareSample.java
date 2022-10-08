package com.test.yxm.ConstructorSample;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class declareSample {
    public static void main(String[] args) {
        try {
            Class employeeClass = Class.forName("com.test.yxm.ConstructorSample.Employee");
            Constructor constructor = employeeClass.getConstructor(new Class[]{Integer.class, String.class, Float.class, String.class});
            Employee employee = (Employee) constructor.newInstance(new Object[]{100, "张三", 1000f, "研发部"});
            Field[] fields = employeeClass.getDeclaredFields();
            for (Field field : fields) {
                //public修饰
                if (field.getModifiers() == 1) {
                    Object val = field.get(employee);
                    System.out.println(field.getName() + ":" + val);
                } else if (field.getModifiers() == 2) {
                    String methodName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                    Method method = employeeClass.getMethod(methodName);
                    Object invoke = method.invoke(employee);
                    System.out.println(field.getName() + ":" + invoke);
                }
            }
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
        }

    }
}
