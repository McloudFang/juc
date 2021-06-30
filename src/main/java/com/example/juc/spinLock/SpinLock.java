package com.example.juc.spinLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLock {
    //Thread 初始默认为null
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    //加锁
    public void myLock(){
        //获取当前线程
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+" ==> myLock");

        //自选锁 期望值不为null 自选等待
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }
    //解锁
    public void UnLock(){
        //获取当前线程
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+" ==> UnLock");
        atomicReference.compareAndSet(thread,null);
    }

    public static void main(String[] args) {
        SpinLock lock = new SpinLock();

        new Thread(()->{
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.UnLock();
            }
        },"A").start();

        new Thread(()->{
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.UnLock();
            }
        },"B").start();

    }

}
