package com.example.juc.threeInterfaces.ReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 模拟缓存
 */
public class MyCatch {
    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Map<String,String> map = new HashMap<>();

    public void write(){
        //写锁上锁
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" 写入");
            map.put(Thread.currentThread().getName(),"1");
            System.out.println("写入完成！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void read(){
        //读锁上锁
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"：读取");
            map.get(Thread.currentThread().getName());
            System.out.println("读取完成！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

}
