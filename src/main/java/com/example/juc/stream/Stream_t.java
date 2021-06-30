package com.example.juc.stream;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 新型编程方式：
 *       lambda表达式
 *       链式编程
 *       函数式接口
 *       Stream流
 *
 * Stream流计算：

 */
public class Stream_t {

    public static void main(String[] args) {
        /**
         * 题目要求：一行代码实现
         *  ID为偶数
         * 名字转成大写
         * 年龄大于23
         * 用户名倒序输出 compareTo 按字典顺序排序
         * 只输出一个
         */
        User user1 = new User(1,"a",23);
        User user2 = new User(2,"b",24);
        User user3 = new User(4,"c",25);
        User user4 = new User(6,"d",26);

        //转换成集合存储
        List<User> list = Arrays.asList(user1,user2,user3,user4);

        //转成流计算
        list.stream()
                .filter(user -> {return (user.getId()%2==0 && user.getAge()>23);})
                .map(user -> {return user.getName().toUpperCase();})
                .sorted((u1,u2)->{return u2.compareTo(u1); }) //倒序
                .limit(2)
                .forEach((String s)->{
                   System.out.println(s);
                 });//BC

        //直接将user类转换成stream流
        Stream<User> stream = Stream.of(user1,user2,user3,user4);

        stream
                .filter(user -> {return user.getId()%2==0 && user.getAge()>23;})
                //类型转换
                .map(user -> {return user.getName().toUpperCase();})
                .sorted((u1,u2)->{return u1.compareTo(u2);}) //正序
//                .sorted((u1,u2)-> u1.compareTo(u2)) //正序
                .limit(2)
                //Lambda表达式转换成方法的引用
                .forEach(System.out::println);//BC

    }


}
