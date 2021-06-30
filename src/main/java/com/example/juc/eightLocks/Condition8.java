package com.example.juc.eightLocks;

import java.util.concurrent.TimeUnit;

//方法被 static 修饰，锁的对象就是 Class模板对象,这个则全局唯一！
//callPhone 没有synchronized修饰 没有锁 不受约束     callPhone
public class Condition8 {

    public static synchronized void sendEmail() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("sendEmail");
    }

    public  void callPhone(){
        System.out.println("callPhone");
    }


}
