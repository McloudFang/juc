package com.example.juc.threeAuxiliaryClasses;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch_A {
    public static void main(String[] args) {
        /**
         *  CountDownLatch 减法计数器
         *  允许一个或多个线程等待直到在其他线程完成一组操作的同步辅助类
         */
        CountDownLatch countDownLatch = new CountDownLatch(10);//允许其他10个线程完成操作

        for (int i = 1; i <= 9; i++) {
            new Thread(()->{
                System.out.println("教室走了"+Thread.currentThread().getName()+"学生");
                //减一
                countDownLatch.countDown();
            },String.valueOf(i)).start();

//           if (countDownLatch.getCount() == 0){
//               continue;
//           }

        }

        //等待计数器归零
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("走了十个学生  教室关门！");
    }
}
