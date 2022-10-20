package com.yxm.spring.ioc;

import com.yxm.spring.ioc.entity.Apple;
import com.yxm.spring.ioc.entity.Chlid;

public class Application {
    public static void main(String[] args) {
        Apple apple1 = new Apple("红富士","红色","亚洲");
        Apple apple2 = new Apple("青苹果","绿色","中亚");
        Apple apple3 = new Apple("金帅","黄色","中国");
        Chlid child1 = new Chlid("孩子1",apple1);
        Chlid child2 = new Chlid("孩子2",apple2);
        Chlid child3 = new Chlid("孩子4",apple3);
        child1.eat();
        child2.eat();
        child3.eat();
    }
}
