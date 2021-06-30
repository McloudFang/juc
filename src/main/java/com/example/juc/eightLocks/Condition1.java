package com.example.juc.eightLocks;
//synchronized 修饰的方式，锁的对象是方法的调用者
public class Condition1 {

    public synchronized void sendEmail(){
        System.out.println("sendEmail");
    }

    public synchronized void callPhone(){
        System.out.println("callPhone");
    }

}
