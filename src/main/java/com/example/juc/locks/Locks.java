package com.example.juc.locks;

import java.util.concurrent.TimeUnit;

public class Locks {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                System.out.print(Thread.currentThread().getName());
                ticket.sale();
            }
        },"a").start();

        new Thread(()->{
            for (int i = 1; i <= 5; i++) {
                System.out.print(Thread.currentThread().getName());
                ticket.sale();
            }
        },"b").start();


    }

}
