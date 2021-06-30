package com.example.juc.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket {
    //票数
    private int number = 10;
    //创建锁
    Lock lock  = new ReentrantLock();

    public void sale(){
        lock.lock();
        try {
            if (number > 0){
                number--;
                System.out.println("剩余："+number+"张票");
            }
        } catch (Exception e) {
           lock.unlock();
        }


    }
}
