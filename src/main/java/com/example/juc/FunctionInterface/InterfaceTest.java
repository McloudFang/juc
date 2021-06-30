package com.example.juc.FunctionInterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 四大主要函数式接口：
 *    Consumer： 消费型接口   只有输出 没有输入
 *    Function： 函数式接口   输入一个 输出一个
 *    Predicate: 断定型接口  输入一个 返回boolean值
 *    Supplier： 供给型接口  输入一个  没有输出
 */
public class InterfaceTest {
    public static void main(String[] args) {
//        //匿名内部类
//        Function function = new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return 1024;
//            }
//        };

        Function<String,Integer> function = (string)->{
            if (string == "1M"){
                return 1024;
            }else {
                return 65536;
            }
        };
        System.out.println(function.apply("123"));
/*****************************************************************/
        Consumer<String> consumer = (s)->{
            if (s == "芝麻开门"){
                System.out.println("开门");
            }else{
                System.out.println("不开");
            }
        };
        consumer.accept("芝麻开门");
/*****************************************************************/

        Supplier<Integer> supplier = ()->{

            return 1024;
        };
        System.out.println(supplier.get());
/*****************************************************************/

        Predicate<String> predicate = (b)->{
            if (b == "Predicate"){
                return true;
            }else {
                return false;
            }
        };
        System.out.println(predicate.test("idea"));
    }

}
