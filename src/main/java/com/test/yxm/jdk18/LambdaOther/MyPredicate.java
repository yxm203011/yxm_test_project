package com.test.yxm.jdk18.LambdaOther;

@FunctionalInterface
public interface MyPredicate<T> {
    public boolean test(T t);
}
