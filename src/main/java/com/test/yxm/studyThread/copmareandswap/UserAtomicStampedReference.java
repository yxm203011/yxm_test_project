package com.test.yxm.studyThread.copmareandswap;

import java.util.concurrent.atomic.AtomicStampedReference;

public class UserAtomicStampedReference {
    static AtomicStampedReference<String> asr = new AtomicStampedReference("mark", 0);

    public static void main(String[] args) throws InterruptedException {
        //当前版本的旧值
        final int oldStamp = asr.getStamp();
        final String oldReference = asr.getReference();

        Thread rightStampThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":当前变量值：" +
                        oldReference + "-当前版本戳：" + oldStamp + "-"
                        + asr.compareAndSet(oldReference, oldReference + "Java", oldStamp, oldStamp + 1));
            }
        });

        Thread errorStampThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String reference = asr.getReference();
                System.out.println(Thread.currentThread().getName() + "：Error当前变量值：" +
                        reference + "-当前版本戳：" + asr.getStamp() + "-" +
                        asr.compareAndSet(reference, reference + "C", oldStamp, oldStamp + 1
                        ));
            }
        });

        rightStampThread.start();
        errorStampThread.start();
        errorStampThread.join();


    }
}
