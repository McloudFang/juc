package com.example.juc.eightLocks;

import java.util.concurrent.TimeUnit;

//callPhone方法没有 synchronized 修饰，不是同步方法，不受锁的影响
public class Condition3 {

    public synchronized void sendEmail() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("sendEmail");
    }

    public void callPhone(){
        System.out.println("callPhone");
    }


}
