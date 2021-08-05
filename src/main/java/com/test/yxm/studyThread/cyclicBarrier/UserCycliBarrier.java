package com.test.yxm.studyThread.cyclicBarrier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

public class UserCycliBarrier {
    private static CyclicBarrier barrier = new CyclicBarrier(4,new CollectThread());

    private static ConcurrentHashMap<String,Long> resultMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        for (int i = 0 ;i<4;i++){
            new Thread(new SubThread()).start();
        }
    }
    private static class CollectThread implements Runnable{
        @Override
        public void run() {
            StringBuffer result = new StringBuffer();
            for (Map.Entry<String, Long> stringLongEntry : resultMap.entrySet()) {
                result.append("["+stringLongEntry.getValue()+"]");
            }
            System.out.println("the result = " + result);
        }
    }
    private static class SubThread implements Runnable{
        @Override
        public void run() {
            long id = Thread.currentThread().getId();
            resultMap.put(Thread.currentThread().getId()+"",id);
            try {
                Thread.sleep(1000+id);
                System.out.println("Thread_"+id+"...do something");
                barrier.await();
                System.out.println("子线程执行结束");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
