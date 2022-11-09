package com.yxm.spring.aop.bookshop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Date;

public class a {

    public void doBefore(JoinPoint joinPoint){
        String name = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("----前置通知------"+name+"."+methodName);
    }

    public void doAfter(JoinPoint joinPoint){
        String name = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("----后置通知------"+name+"."+methodName);
    }

    public void doReturning(JoinPoint joinPoint,Object obj){
        System.out.println("----返回后通知------"+obj);
    }
    public void doAfterThrowing(JoinPoint joinPoint,Throwable throwable){
        System.out.println("----异常通知------"+throwable);
    }

    public Object check(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            long startTime = new Date().getTime();
            Object obj = proceedingJoinPoint.proceed();
            long entTime = new Date().getTime();
            long l = entTime - startTime;
            if(l > 1000){
                System.out.println("方法执行时间过长");
            }
            return obj;
        } catch (Throwable throwable) {
            throw throwable;
        }
    }
}
