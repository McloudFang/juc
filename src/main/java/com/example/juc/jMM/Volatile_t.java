package com.example.juc.jMM;

import javax.print.attribute.IntegerSyntax;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Volatile的特性：
 *     保证可见性
 *    不保持原子性
 *    禁止指令重排
 */

public class Volatile_t {

//    private  static  int num = 0;
//
//    public synchronized static void add(){
//        /**
//         * 不是原子性操作 分三步
//         *   取值
//         *   加一
//         *   存值
//         */
//        num++;
//    }
    //原子类
    private volatile static AtomicInteger num = new AtomicInteger();

    public synchronized static void add(){
        //原子性操作 +1
        num.getAndIncrement();
    }

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        //main gc
        while (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(num);
    }
}
