package com.example.juc.deadLock;

import java.util.concurrent.TimeUnit;

public class DeadLock {

    public static void main(String[] args) {

        new Thread(new myThread("lockA","lockB")).start();
        new Thread(new myThread("lockB","lockA")).start();
    }
}

class myThread implements Runnable{
    //两个资源
    private String lockA;
    private String lockB;

    public myThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+" 锁住了："+lockA+" 想去获取："+lockB);

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+" 锁住了："+lockB+" 想去获取："+lockA);
            }
        }
    }
}