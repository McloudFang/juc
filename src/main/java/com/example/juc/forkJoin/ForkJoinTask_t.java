package com.example.juc.forkJoin;


import java.util.concurrent.RecursiveTask;
/**
 * Task：
 *    计算 1-n的加法和
 *    当 n>1000000时用forkJoin方法
 */
public class ForkJoinTask_t extends RecursiveTask<Long> {
   private Long start;
   private Long end;

   //设置拆分门限
   long temp = 1000000L;

   public ForkJoinTask_t(Long start,Long end){
       this.start = start;
       this.end = end;
   }

    @Override
    protected Long compute() {
       //起始差值
        long len = end - start;
       if (len <= temp){
           long sum = 0L ;
           for (long i = start; i <= end ; i++) {

               sum += i ;
           }
           return sum;
       }else {
           long middle = start + (end - start)/2;
           ForkJoinTask_t forkJoinTask1= new ForkJoinTask_t(start,middle);
           forkJoinTask1.fork();
           //都是开区间  记得加一！！！
           ForkJoinTask_t forkJoinTask2 = new ForkJoinTask_t(middle+1,end);
           forkJoinTask2.fork();

           return forkJoinTask1.join() + forkJoinTask2.join();
       }
    }
}
