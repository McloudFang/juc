package com.example.juc.eightLocks;

import java.util.concurrent.TimeUnit;

//synchronized 锁的是两个不同的调用者，所有互不影响，sendEmail()有延时  callPhone
public class Condition4 {

    public synchronized void sendEmail() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("sendEmail");
    }

    public synchronized void callPhone(){
        System.out.println("callPhone");
    }


}
