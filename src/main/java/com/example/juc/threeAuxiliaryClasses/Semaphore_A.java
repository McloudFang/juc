package com.example.juc.threeAuxiliaryClasses;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Semaphore_A {
    public static void main(String[] args) {
        /**
         * Semaphore: 一种计数信号量
         * 信号量维持一组许可证。如果有必要，每个acquire()都会阻塞，直到许可证可用，然后才能使用它。
         * 每个release()添加许可证，潜在地释放阻塞获取方
         */
        //给定许可证的数量 3
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 3; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();//获取许可证
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    System.out.println(Thread.currentThread().getName()+"停车三秒");
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//释放许可
                    System.out.println(Thread.currentThread().getName()+"释放了车位");
                }

            },String.valueOf(i)).start();
        }
    }
}
