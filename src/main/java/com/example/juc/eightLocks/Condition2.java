package com.example.juc.eightLocks;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.TimeUnit;

//synchronized 修饰的方式，锁的对象是方法的调用者
public class Condition2 {

    public synchronized void sendEmail() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("sendEmail");
    }

    public synchronized void callPhone(){
        System.out.println("callPhone");
    }


}
