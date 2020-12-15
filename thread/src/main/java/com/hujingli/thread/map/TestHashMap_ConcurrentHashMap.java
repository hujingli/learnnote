package com.hujingli.thread.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestHashMap_ConcurrentHashMap {

    public static Map<String, String> map = new HashMap<>();
    public static Map<Object, Object> con_map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
//        testHashMap();
//        testConcurrentHashMap();
        testMap();
    }

    public static void testMap() {
        for (int i = 0; i < 14; i++) {
            map.put("i" + i, "i" + i);
        }
    }

    public static void testHashMap() throws InterruptedException {
        for (Integer i = 0; i < 1000; i++) {
            Integer finalI = i;
            Integer finalI1 = i;
            new Thread(() -> {
//                double random = Math.random();
//                map.put(finalI, finalI1);
//                map.remove(finalI);
            }).start();
        }
        Thread.sleep(10000);
        System.out.println(map.size());
    }

    public static void testConcurrentHashMap() throws InterruptedException {
        for (Integer i = 0; i < 1000; i++) {
            Integer finalI = i;
            Integer finalI1 = i;
            new Thread(() -> {
//                double random = Math.random();
                con_map.put(finalI, finalI1);
//                con_map.remove(random);
            }).start();
        }
        Thread.sleep(10000);
        System.out.println(con_map.size());
    }

}

