package com.example.juc.singleton;

public class Hungry {

    private static Hungry hungry = new Hungry();
    private Hungry(){
        System.out.println("饿汉单例模式");
    }

    public static Hungry getHungry() {
        return hungry;
    }

    public static void main(String[] args) {
        Hungry.getHungry();
    }
}
