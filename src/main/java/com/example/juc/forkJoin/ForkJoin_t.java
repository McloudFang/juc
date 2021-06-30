package com.example.juc.forkJoin;


import cn.hutool.core.text.csv.CsvUtil;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * 将大任务拆分成小任务fork，再将所有的小任务结果集合join
 *
 * ForkJoin的使用：
 *     创建ForkJoin任务 ForkJoinTask的实现类 RecursiveTask<>
 *     创建ForkJoinPool 执行任务
 */
public class ForkJoin_t {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1();
        test2();
    }

    //ForkJoin
    public static void test1() throws ExecutionException, InterruptedException {

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask_t task = new ForkJoinTask_t(0L,1000000000L);
        Long invoke = pool.invoke(task);
        System.out.println(invoke);

    }
    //Stream 并行流
    public static void test2(){
        //rangeClose左开右闭
        long sum = LongStream.rangeClosed(0L,5L).parallel().reduce(0, Long::sum);
        System.out.println(sum);
    }


}
