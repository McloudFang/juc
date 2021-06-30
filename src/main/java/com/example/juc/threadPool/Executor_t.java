package com.example.juc.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一般不用这种方式创建
 * Executor : 创建线程池的三种方法
 *       SingleThreadExecutor  单个线程池
 *       FixedThreadExecutor   固定线程池
 *       cacheThreadExecutor   缓存线程池
 */
public class Executor_t {
    public static void main(String[] args) throws InterruptedException {
        //单个线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        //固定线程池 3
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        //缓存线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        try {

            for (int i = 1; i <= 3; i++) {
                singleThreadExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" single");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭线程池
            singleThreadExecutor.shutdown();
        }
        /**********************fixed*************************/
        try {
            for (int i = 1; i <= 3; i++) {
                fixedThreadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" fixed");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭线程池
            fixedThreadPool.shutdown();
        }

        /*******************cache***************************/
        try {

            for (int i = 1; i <= 3; i++) {
                cachedThreadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" cache");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭线程池
            cachedThreadPool.shutdown();
        }


    }
}
