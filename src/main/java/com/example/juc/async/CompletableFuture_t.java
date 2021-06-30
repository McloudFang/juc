package com.example.juc.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 异步回调
 */
public class CompletableFuture_t {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1();
        test2();
    }

    /**
     * 无返回值的异步回调  runAsync
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void test1() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"：异步线程");
        }));


        System.out.println(Thread.currentThread().getName()+": 主线程");
        //获取异步执行结果
        completableFuture.get();
    }

    public static void test2() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            int a = 10/0;
            System.out.println(Thread.currentThread().getName()+"：异步线程");
            //成功返回码 0
            return 0;
        });
        System.out.println(Thread.currentThread().getName()+": 主线程");

        CompletableFuture<Integer> exceptionally = completableFuture.whenComplete((k, v) -> {
            //成功 返回0
            System.out.println("success ：" + k);
            //失败 抛出异常
            if (v != null){
                System.out.println("Exception" + v);
            }
        }).exceptionally((e) -> {
            //失败返回码
            return 500;
        });
        //返回码
        System.out.println("返回码 : "+exceptionally.get());
    }
}
