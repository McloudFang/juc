package com.example.juc.singleton;

public class DCL {

    private volatile static DCL dcl ;

    private DCL(){
        System.out.println(Thread.currentThread().getName());
    }

    public static DCL getDcl() {

        if (dcl == null){
            //同步代码块锁住
            synchronized (DCL.class){
                if (dcl == null){
                    //不是原子性操作
                    dcl = new DCL();
                }
            }
        }
        return dcl;
    }

}
