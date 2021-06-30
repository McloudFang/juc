package com.example.juc.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 创建线程池的方法
 * ThreadPoolExecutor(int corePoolSize,           核心线程数
 *                    int maximumPoolSize,        最大并发线程数
 *                    long keepAliveTime,         最大并发开启的线程  超时未使用就关闭
 *                    TimeUnit unit,              时间单位
 *                    BlockingQueue<Runnable> workQueue,  阻塞队列
 *                    ThreadFactory threadFactory,        线程工厂(默认值)
 *                    RejectedExecutionHandler handler)   拒绝策略
 */
public class ThreadPoolExecutor_t {
    public static void main(String[] args) {
     ThreadPoolExecutor threadPoolExecutor=   new ThreadPoolExecutor(1,
                                                                    3,
                                                                    3,
                                                                    TimeUnit.SECONDS,
                                                                    new ArrayBlockingQueue(3),
                                                                    Executors.defaultThreadFactory(),
                                                                    new ThreadPoolExecutor.DiscardOldestPolicy());
        try {

            //i = 5 = corePoolSize + 阻塞队列Capacity + 1  启动maximumPoolSize 的一条线程
            //i = 6 = corePoolSize + 阻塞队列Capacity + 2  启动maximumPoolSize 的两条线程
            //i = 7 = corePoolSize + 阻塞队列Capacity + 3  超过了最大线程承载数：阻塞队列Capacity + 启动maximumPoolSize 实行拒绝策略
            /**
             * 四种拒绝策略：
             *    1、AbortPolicy()        不处理抛出异常
             *    2、CallerRunsPolicy()   遣返到 main线程执行
             *    3、DiscardPolicy()      丢弃任务 不抛出异常
             *    4、DiscardPolicy()      和最早的任务竞争，不管最早的有没有执行完成，挤掉最早的任务
             */
            for (int i = 1; i <= 7; i++) {
                final int temp = i;
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"线程在执行：第"+ temp +"任务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }

    }
}
