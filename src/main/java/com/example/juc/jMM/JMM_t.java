package com.example.juc.jMM;

import java.util.concurrent.TimeUnit;

public class JMM_t {

    private volatile static int num = 0;

    public static void main(String[] args) {
        //线程一
        new Thread(()->{
            while (num==0){

            }
        }).start();
        //线程二
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num = 1;
            System.out.println(num);
        }).start();
    }
}
