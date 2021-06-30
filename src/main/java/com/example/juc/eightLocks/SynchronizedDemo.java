package com.example.juc.eightLocks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public class SynchronizedDemo {
    public static void main(String[] args) throws InterruptedException {
//        Condition1 condition = new Condition1();
//        Condition2 condition = new Condition2();
//        Condition3 condition = new Condition3();

//        Condition4 condition = new Condition4();
//        Condition4 condition1 = new Condition4();

//        Condition5 condition = new Condition5();
//        Condition6 condition = new Condition6();

//          Condition7 condition = new Condition7();
//          Condition7 condition1 = new Condition7();

          Condition8 condition = new Condition8();

        new Thread(()->{
            try {
                condition.sendEmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"a").start();

        new Thread(()->{
            condition.callPhone();
        },"b").start();

    }
}
