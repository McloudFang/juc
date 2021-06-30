package com.example.juc.threeInterfaces.demo;

public class Condition_Lock_i {
    public static void main(String[] args) {
//        ResourceEntity entity = new ResourceEntity();
        LockResourceEntity entity = new LockResourceEntity();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                entity.get();
            }
        },"a").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                entity.put();
            }
        },"b").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                entity.get();
            }
        },"c").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                entity.put();
            }
        },"d").start();
    }
}
