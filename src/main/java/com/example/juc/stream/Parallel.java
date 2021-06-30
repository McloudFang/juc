package com.example.juc.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Parallel {
    public static void main(String[] args) {
//        method();
        methodOne();
        methodTwo();
        methodThree();

    }
    //ParallelStream线程不安全 ArrayIndexOutOfBoundsException
    public static void method(){
        List<Integer> list = new ArrayList<>();

        IntStream.rangeClosed(1,1000000).parallel().forEach((integer)->{
            list.add(integer);
        });
        System.out.println("listSize = " + list.size());
    }

    //解决ParallelStream线程安全 方法一
    public static void methodOne(){
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        IntStream.rangeClosed(1,1000000).parallel().forEach((integer)->{
            list.add(integer);
        });
        System.out.println("listSize = " + list.size());
    }

    //解决ParallelStream线程安全 方法二
    public static void methodTwo(){
        List<Integer> list = new CopyOnWriteArrayList<>();

        IntStream.rangeClosed(1,1000000).parallel().forEach((integer)->{
            list.add(integer);
        });
        System.out.println("listSize = " + list.size());
    }

    //解决ParallelStream线程安全 方法三
    public static void methodThree(){

        List<Integer> list = IntStream
                .rangeClosed(1, 1000000)
                .parallel()
                .boxed()
                .collect(Collectors.toList());
        System.out.println("listSize = " + list.size());
    }

}


