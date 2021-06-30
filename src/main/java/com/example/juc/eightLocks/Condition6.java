package com.example.juc.eightLocks;

import java.util.concurrent.TimeUnit;

//方法被 static 修饰，锁的对象就是 Class模板对象,这个则全局唯一！
//synchronized 修饰的方式，锁的对象是方法的调用者 两者锁的不是一个对象 callPhone
public class Condition6 {

    public static synchronized void sendEmail() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("sendEmail");
    }

    public synchronized void callPhone(){
        System.out.println("callPhone");
    }


}
