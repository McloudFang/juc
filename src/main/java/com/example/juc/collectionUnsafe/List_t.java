package com.example.juc.collectionUnsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class List_t {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();//ConcurrentModificationException 并发修改异常

        List<String> listVector = new Vector<>();//Synchronized 效率低

        List<String> listColl = Collections.synchronizedList(new ArrayList<>());

        List<String> listCopy = new CopyOnWriteArrayList<>();//写入时复制 复制完再插入 避免覆盖  Lock锁

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                listCopy.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(listCopy);},String.valueOf(i)
            ).start();
        }



    }
}
