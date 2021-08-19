package com.test.yxm.junit.studyThread.rw;

import java.util.Random;

public class BusiApp {
    static final int readWriteRatio = 10;
    static final int minthredCount = 3;

    public static class GetThread implements Runnable {
        private GoodsService goodsService;

        public GetThread(GoodsService goodsService) {
            this.goodsService = goodsService;
        }


        @Override
        public void run() {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) {
                try {
                    goodsService.getNum();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "读取商品数据耗时：" + (System.currentTimeMillis() - start) + "ms");
        }
    }

    private static class SetThread implements Runnable {
        private GoodsService goodsService;

        public SetThread(GoodsService goodsService) {
            this.goodsService = goodsService;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            Random r = new Random();
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(50);
                    goodsService.setNum(r.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "写商品数据耗时：" + (System.currentTimeMillis() - start) + "ms-----------");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        GoodsInfo goodsInfo = new GoodsInfo("Cpu", 100000, 10000);
        GoodsService goodsService = new UseRwLock(goodsInfo); //new UseSyn(goodsInfo);
        for (int i = 0; i < minthredCount; i++) {
            Thread setT = new Thread(new SetThread(goodsService));
            for (int j = 0; j < readWriteRatio; j++) {
                Thread getT = new Thread(new GetThread(goodsService));
                getT.start();
            }
            Thread.sleep(100);
            setT.start();
        }
    }
}
