package com.example.juc.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * BlockingQueue:阻塞队列  --->  Queue ---> Collection
 * 实现类：
 *   ArrayBlockingQueue  LinkedBlockingQueue
 */
public class BlockingQueue_t {

    public static void main(String[] args) throws InterruptedException {
       BlockingQueue_t blockingQueue_t = new BlockingQueue_t();

       //1、抛出异常
       blockingQueue_t.Test1();

       //2、返回值
       blockingQueue_t.Test2();

       //3、一直等待
       blockingQueue_t.Test3();

       //4、超时等待 2s
       blockingQueue_t.Test4();

    }

    /**
     * 情景一：抛出异常
     *      add
     *      remove
     */
    public void Test1(){
        //队列容量3
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.add("1");
        blockingQueue.add("1");
        blockingQueue.add("1");
        blockingQueue.add("1");//IllegalStateException: Queue full

        blockingQueue.remove();
        blockingQueue.remove();
        blockingQueue.remove();
    }

    /**
     * 情景二：有异常返回值
     *      offer  成功输出 true
     *             失败输出 false
     *      poll
     */

    public void Test2(){
        //队列容量3
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(2);
        System.out.println(blockingQueue.offer("1"));
        System.out.println(blockingQueue.offer("1"));
        System.out.println(blockingQueue.offer("1"));

        blockingQueue.poll();
        blockingQueue.poll();
        blockingQueue.poll();
    }

    /**
     * 情景三： 有阻塞一直等待  直到不堵塞
     *       put
     *       take
     */
    public void Test3() throws InterruptedException {
        LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(3);

        blockingQueue.put(1);
        System.out.println(1);
        blockingQueue.put(1);
        System.out.println(2);
        blockingQueue.put(1);
        System.out.println(3);
        blockingQueue.put(1);//一直等待
        System.out.println(4);

        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();

    }

    /**
     * 情景四： 阻塞超时等待
     *     offer(E e, long timeout, TimeUnit unit)
     *     poll()
     */
    public void Test4() throws InterruptedException {
        LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(3);
        blockingQueue.offer(1,2, TimeUnit.SECONDS);
        System.out.println(1);
        blockingQueue.offer(1,2, TimeUnit.SECONDS);
        System.out.println(2);
        blockingQueue.offer(1,2, TimeUnit.SECONDS);
        System.out.println(3);
        blockingQueue.offer(1,2, TimeUnit.SECONDS);
        System.out.println(4);//堵塞2s后 在执行

        blockingQueue.poll();
        blockingQueue.poll();
        blockingQueue.poll();

    }
}
