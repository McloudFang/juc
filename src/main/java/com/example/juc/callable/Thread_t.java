package com.example.juc.callable;

import java.util.concurrent.Callable;

//Callable 线程可以返回结果（类型是个泛型）也可以抛出异常
public class Thread_t implements Callable<String> {
    @Override
    public String call() throws Exception {
        //线程执行内容
        System.out.println("callable");
        return "1024";
    }
}
