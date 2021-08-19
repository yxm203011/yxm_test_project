package com.test.yxm.junit.studyThread;

public class biubiubiu {

    private int allzdNumber = 0;//枪膛子弹数

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public biubiubiu(int allzdNumber, String name) {
        this.allzdNumber = allzdNumber;
        this.name = name;
    }

    public synchronized void addzd() throws InterruptedException {
        while (this.allzdNumber != 20)
            wait();
        System.out.println("子弹已上满");
    }

    public synchronized void subzd() throws InterruptedException {
        while (this.allzdNumber != 0)
            wait();
        System.out.println("子弹已经打光");
    }

    public synchronized void zd() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("正在装弹第"+i);
            this.allzdNumber++;
        }
        notifyAll();
    }

    public synchronized void dazidan() {
        for (int i = this.allzdNumber; i > 0; i--) {
            System.out.println(this.name+"正在打枪，剩余子弹数"+i);
            this.allzdNumber--;
        }
        notifyAll();
    }


}
