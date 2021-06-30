package com.example.juc.collectionUnsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Map_t {
    public static void main(String[] args) {
        //static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // 默认容量 16
        //static final float DEFAULT_LOAD_FACTOR = 0.75f;// 默认填充比
        Map<String,String> map = new HashMap<>(16,0.75f);//ConcurrentModificationException
        //线程安全
        Map<String,String> mapColl = Collections.synchronizedMap(new HashMap<>());

        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                mapColl.put(UUID.randomUUID().toString().substring(0,5),"密码");
                System.out.println(mapColl);
            }).start();
        }
    }
}
