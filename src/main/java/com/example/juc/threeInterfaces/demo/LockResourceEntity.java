package com.example.juc.threeInterfaces.demo;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Lock锁
public class LockResourceEntity {

    private int number = 0;
    //创建锁
    Lock lock = new ReentrantLock();
    //condition接口 取代object监视器
    Condition condition = lock.newCondition();

    public void get(){

        lock.lock();
        try {

            while (number >= 10 ){

                //队列还有数据就等待
                condition.await();
            }
            //生产者生产
            number++;
            System.out.println(Thread.currentThread().getName()+" 存储数量: "+number);
            //生产完毕  唤醒消费者
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


    public void put(){
        lock.lock();
        try {

            while (number == 0){
                //队列无数据
               condition.await();
            }
            //消费者消费
            number--;
            System.out.println(Thread.currentThread().getName()+" 剩余数量： "+number);

            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}
