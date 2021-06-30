package com.example.juc.threeAuxiliaryClasses;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrier_A {
    public static void main(String[] args) {
        /**
         * CyclicBarrier 加法计数器
         * 允许一组线程等待彼此达到一个共同的屏障的同步辅助
         *
         * 构造方法 ：
         *     CyclicBarrier(int parties, Runnable barrierAction)
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,new Thread(()->{
            System.out.println("召唤神龙");
        }));

        for (int i = 1; i <= 8; i++) {
            new Thread(()->{
                System.out.println("收集了"+Thread.currentThread().getName()+"龙珠");
                try {
                    //等待达到共同屏障点
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }
}
