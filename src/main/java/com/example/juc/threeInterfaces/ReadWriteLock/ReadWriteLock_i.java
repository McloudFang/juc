package com.example.juc.threeInterfaces.ReadWriteLock;


/**
 * 读写锁 包括读锁和写锁
 * 实现类：ReentrantReadWriteLock
 * 两个方法：
 *     readLock()
 *     writeLock()
 */
public class ReadWriteLock_i {
    public static void main(String[] args) {
     MyCatch myCatch = new MyCatch();

        for (int i = 1; i <= 5; i++) {
            new Thread(()->{
                myCatch.write();
                myCatch.read();
            },String.valueOf(i)).start();
        }

    }
}
