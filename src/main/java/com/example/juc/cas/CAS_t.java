package com.example.juc.cas;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CAS_t {
    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(1);

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicInteger.compareAndSet(1, 2));
            System.out.println(Thread.currentThread().getName()+": "+atomicInteger.get());

        },"A").start();

        new Thread(()->{

            //达到期望 更新
            //public final boolean compareAndSet(int expect, int update)
            atomicInteger.compareAndSet(1,3);

            atomicInteger.compareAndSet(3,1);
            System.out.println(Thread.currentThread().getName()+": "+atomicInteger.get());
        },"B").start();

    }
}
