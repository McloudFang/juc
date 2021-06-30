package com.example.juc.eightLocks;

import java.util.concurrent.TimeUnit;

//方法被 static 修饰，锁的对象就是 Class模板对象,这个则全局唯一！
//不同调用的对象 也是同一个锁  先调用先执行 sendEmail
public class Condition7 {

    public static synchronized void sendEmail() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("sendEmail");
    }

    public static synchronized void callPhone(){
        System.out.println("callPhone");
    }


}
