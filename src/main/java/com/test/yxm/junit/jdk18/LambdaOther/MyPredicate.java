package com.test.yxm.junit.jdk18.LambdaOther;

@FunctionalInterface
public interface MyPredicate<T> {
    public boolean test(T t);
}
