package com.example.juc.singleton;

public class Lazy {

    private static Lazy lazy ;

    private Lazy(){
        System.out.println(Thread.currentThread().getName());
    }

    public static Lazy getLazy() {
        if (lazy == null){
            //不是原子性操作
            lazy = new Lazy();
        }
        return lazy;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            new Thread(()->{
               Lazy.getLazy();
            }).start();
        }
    }
}
