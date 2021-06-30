package com.example.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;

public class Atomic_ACS {
    public static void main(String[] args) {
        //Stamp : 版本号
        AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(1, 1);
        int stamp = stampedReference.getStamp();

        new Thread(() -> {
            System.out.println("A1: " + stampedReference.getStamp());
            stampedReference.compareAndSet(1, 2,
                    stampedReference.getStamp(), stampedReference.getStamp() + 1);

            System.out.println("A2: " + stampedReference.getStamp());
            System.out.println("A: " + stampedReference.compareAndSet(2, 1,
                    stampedReference.getStamp(), stampedReference.getStamp() + 1));

            System.out.println("A3: " + stampedReference.getStamp());
        }, "A").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B: " + stampedReference.compareAndSet(1, 6,
                    stamp, stamp + 1));
            System.out.println("B1: " + stampedReference.getStamp());
        }, "B").start();

    }
}
