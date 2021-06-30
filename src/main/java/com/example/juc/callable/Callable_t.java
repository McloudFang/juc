package com.example.juc.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Callable_t {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread_t myThread = new Thread_t();
        /**
         * FutureTask(Callable<V> callable)是Runnable的实现类
         * 传入一个Callable实例
         */
        FutureTask futureTask = new FutureTask(myThread);

        new Thread(futureTask,"a");
//        new Thread(futureTask,"b");

        //获取返回结果
        String s = (String) futureTask.get();
        System.out.println(s);

    }
}



