package com.example.juc.collectionUnsafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class Set_t {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();//ConcurrentModificationException 并发修改异常

        //线程安全的
        Set<String> setColl = Collections.synchronizedSet(new HashSet<>());

        Set<String> setCopy = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                setCopy.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(setCopy);},String.valueOf(i)
            ).start();
        }

    }


}
