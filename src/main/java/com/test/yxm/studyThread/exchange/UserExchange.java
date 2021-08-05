package com.test.yxm.studyThread.exchange;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Exchanger;

public class UserExchange {
    private static final Exchanger<Set<String>> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Set<String> setA = new HashSet<>();
                setA.add("a1");
                try {
                    setA = exchanger.exchange(setA);
                    System.out.println("A的数据"+setA);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Set<String> setB = new HashSet<>();
                setB.add("b1");
                try {
                    setB = exchanger.exchange(setB);
                    System.out.println("B的数据"+setB);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
