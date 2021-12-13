package com.test.yxm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class test {

    public static void main(String[] args) throws Exception {
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if(method.getName().equals("getName")){
                    System.out.println("名字："+args[0]);
                }
                return null;
            }
        };
        aaa a = (aaa)Proxy.newProxyInstance(aaa.class.getClassLoader(),new Class[]{aaa.class},invocationHandler);
        a.getName("aaaaaa");
    }
}
