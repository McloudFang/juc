package com.example.juc.threeInterfaces.demo;



//传统synchronized 锁
public class ResourceEntity {
    private int number = 0;

    public synchronized void get(){
        while (number >= 5 ){
            try {
                //队列还有数据就等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //生产者生产
        number++;
        System.out.println(Thread.currentThread().getName()+" 存储数量: "+number);
        //生产完毕  唤醒消费者
        notify();
    }


    public synchronized void put(){
        while (number == 0){
            //队列无数据
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //消费者消费
        number--;
        System.out.println(Thread.currentThread().getName()+" 剩余数量： "+number);

        notify();
    }

}
