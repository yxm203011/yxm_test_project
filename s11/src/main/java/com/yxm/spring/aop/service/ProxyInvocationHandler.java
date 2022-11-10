package com.yxm.spring.aop.service;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class ProxyInvocationHandler implements InvocationHandler {

    private Object target;

    public ProxyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("======当前时间======");
        Object ret = method.invoke(target,args);//调用目标方法
        return ret;
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler(userService);
        UserService userServiceProxy = (UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                proxyInvocationHandler);
        userServiceProxy.createUser();

        EmployeeService employeeService = new EmployeeServiceImpl();
        EmployeeService employee = (EmployeeService)Proxy.newProxyInstance(employeeService.getClass().getClassLoader(),
                employeeService.getClass().getInterfaces(),
                new ProxyInvocationHandler(employeeService));
        employee.createEmployee();
    }

}
