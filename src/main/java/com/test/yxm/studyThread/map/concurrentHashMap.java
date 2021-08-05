package com.test.yxm.studyThread.map;

import java.util.concurrent.ConcurrentHashMap;

public class concurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap<KeyVo, String> map = new ConcurrentHashMap<>();
        KeyVo keyVo = new KeyVo(1, "A");
        System.out.println("------不存在的值------");
        System.out.println(map.put(keyVo, "AA"));
        System.out.println(map.get(keyVo));
        System.out.println("-----put已经存在的Key------");
        System.out.println(map.put(keyVo, "BB"));
        System.out.println(map.get(keyVo));
        System.out.println("------putIfAbsent存在的Key值-------");
        System.out.println(map.putIfAbsent(keyVo, "CC"));
        System.out.println(map.get(keyVo));
        System.out.println("------putIfAbsent已经存在的值--------");
        KeyVo keyVo1 = new KeyVo(2, "B");
        System.out.println(map.putIfAbsent(keyVo1, "CC"));
        System.out.println(map.get(keyVo));

        ConcurrentHashMap<KeyVo, String> map2 = new ConcurrentHashMap<KeyVo, String>(2, 0.75f, 16);
    }
}
