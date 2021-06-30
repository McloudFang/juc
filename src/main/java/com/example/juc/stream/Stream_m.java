package com.example.juc.stream;

import java.lang.reflect.Array;
import java.security.cert.CollectionCertStoreParameters;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *收集Stream流中的结果
 */
public class Stream_m {
    public static void main(String[] args) {
//        distinctTest();
//        collectTest();
//        groupingByTest();
//        partitionByTest();
        joiningTest();
    }

    /**
     * 去除重复 自定义类需要重写自定义类的equals和hashcode方法
     */
    public static void distinctTest(){
        User user1 = new User(2,"a",23);
        User user2 = new User(2,"a",23);
        User user3 = new User(4,"c",25);
        User user4 = new User(6,"d",26);
        System.out.println("自定义类");
        List<User> listU = Arrays.asList(user1,user2,user3,user4);
        listU.stream()
                      .distinct()
                      .forEach(System.out::println);

        List<String> list = new ArrayList<>();

        list.add("1");
        list.add("3");
        list.add("2");
        list.add("1");
        System.out.println("字符串");
        list.stream()
                .distinct()
                .forEach(System.out::println);
    }
    /**
     * 流转换成集合
     */
     public static void collectTest(){
         //list集合
         User user1 = new User(2,"a",23);
         User user2 = new User(2,"a",23);
         User user3 = new User(4,"c",25);
         User user4 = new User(6,"d",26);
         Stream stream = Stream.of(user1,user2,user3,user4);
         System.out.println("list集合");
         System.out.println(stream.collect(Collectors.toList()));

         //Map集合
         Map<String,String> map = new HashMap<>();
         map.put("hsj","36D");
         map.put("htt","35D");
         map.put("hhh","34D");
         map.put("true","80c");
         Stream stream1 = Stream.of(map);
         System.out.println("map集合");
         System.out.println(stream1.collect(Collectors.toMap((k)->{return k.toString();},(v)->{return v.toString();})));

         //Set集合
         Stream stream2 = Stream.of("hsj","1024","1024");
         System.out.println("set集合");
         System.out.println(stream2.collect(Collectors.toSet()));

         //特定集合
         Stream stream3 = Stream.of("hsj","1024","1024");
         System.out.println(stream3.collect(Collectors.toCollection(ArrayList::new)));

         //数组
         Stream stream4 = Stream.of(1,2,3);
         Object[] objects = stream4.toArray(Integer::new);
         System.out.println(objects.toString());

         stream4.toArray((integer)->{
             return new Integer[integer];
         });
//         stream2.toArray(int[]::new);
//         stream2.toArray(Long[]::new);
     }

    /**
     * 将流中的结果分组
     */
    public static void groupingByTest(){
        //单级分组
        User user1 = new User(2,"a",23);
        User user2 = new User(2,"b",25);
        User user3 = new User(4,"c",24);
        User user4 = new User(4,"d",26);
        Stream<User> stream = Stream.of(user1,user2,user3,user4);
        Object collect = stream.collect(Collectors.groupingBy((User u) -> {
            return u.getId() % 2 == 0;
        }));
        System.out.println("单级分组");
        System.out.println(collect.toString());

        //多级分组
        Stream<User> streams = Stream.of(user1,user2,user3,user4);
        //第一级按按id分  第二级按年龄分
        Map<Integer, Map<String, List<User>>> map = streams.collect(Collectors.groupingBy(User::getId, Collectors.groupingBy((user) -> {
            if (user.getAge() > 24) {
                return "年龄大";
            } else {
                return "年龄小";
            }
        })));

        map.forEach((k,v)->{
            System.out.println(k);
            //v还是个map集合
            v.forEach((k2,v2)->{
                System.out.println("\t" +k2+"-->"+v2);
            });
        });
    }

    /**
     * 将流中的结果分区  只有两种结果true false
     */
    public static void partitionByTest(){

        User user1 = new User(2,"a",23);
        User user2 = new User(2,"b",25);
        User user3 = new User(4,"c",24);
        User user4 = new User(4,"d",26);
        Stream<User> stream = Stream.of(user1,user2,user3,user4);
        Map<Boolean, List<User>> map = stream.collect(Collectors.partitioningBy(u -> {
            return u.getAge() > 24;
        }));
        map.forEach((k,v)->{
            System.out.println(k);
            v.forEach(s->{
                System.out.println("\t"+s);
            });
        });

    }


    /**
     * 将流中的结果分区  只有两种结果true false
     */
    public static void joiningTest(){

        User user1 = new User(2,"a",23);
        User user2 = new User(2,"b",25);
        User user3 = new User(4,"c",24);
        User user4 = new User(4,"d",26);
        Stream<User> stream1 = Stream.of(user1,user2,user3,user4);
        Stream<User> stream2 = Stream.of(user1,user2,user3,user4);

//        Stream<String> stream1 = stream.map(User::getName);
//        stream1.forEach(System.out::println);
        //  a-b-c-d
        System.out.println(stream1.map(User::getName).collect(Collectors.joining("-")));
        //^_^a_b_c_d`~`
        System.out.println(stream2.map(User::getName).collect(Collectors.joining("_","^_^","`~`")));


    }
}
