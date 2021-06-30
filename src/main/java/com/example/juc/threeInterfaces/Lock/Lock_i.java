package com.example.juc.threeInterfaces.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock_i {
    public static void main(String[] args) {
        //lock锁的一般实现形式
        Lock lock = new ReentrantLock();

        lock.lock();
        try {
            //业务代码
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
