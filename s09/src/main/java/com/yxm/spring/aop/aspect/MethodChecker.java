package com.yxm.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect //说明当前类是切面类
public class MethodChecker {

    //环绕通知（参数为切点的表达式）
    @Around("execution(* com.yxm..*Service.*(..))")
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
