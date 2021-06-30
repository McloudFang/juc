package com.example.juc.blockingQueue;

import java.sql.Time;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列 一次只能进入一个 上一个出来下一个在进
 */
public class SynchronousQueue_t {
    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"=> put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"=> put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"=> put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程1").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                blockingQueue.poll();
                System.out.println(Thread.currentThread().getName()+"=> poll 1");
                blockingQueue.poll();
                System.out.println(Thread.currentThread().getName()+"=> poll 2");
                blockingQueue.poll();
                System.out.println(Thread.currentThread().getName()+"=> poll 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程2").start();
    }
}
