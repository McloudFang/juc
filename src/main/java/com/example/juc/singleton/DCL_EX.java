package com.example.juc.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class DCL_EX {

    private volatile static DCL_EX dcl ;
    /**
     * 加密预防：不创建对象  反射创建两个对象破坏单例
     */
    private static boolean flag = false;

    private DCL_EX(){
            /**
             * 构造器加锁预防:一个正常创建  一个反射创建
             */
            synchronized (DCL_EX.class){
                if (flag == false){
                    flag = true;
                }  else {
                    throw new RuntimeException("不要试图反射破坏");
            }
        }

    }

    public static DCL_EX getDcl() {

        if (dcl == null){
            //同步代码块锁住
            synchronized (DCL_EX.class){
                if (dcl == null){
                    //不是原子性操作
                    dcl = new DCL_EX();
                }
            }
        }
        return dcl;
    }

    public static void main(String[] args) throws Exception{

        //DCL_EX dcl = DCL_EX.getDcl();

        //获取无参构造
        Constructor<DCL_EX> declaredConstructor = DCL_EX.class.getDeclaredConstructor(null);
        //破除私有权限
        declaredConstructor.setAccessible(true);
        //fan'z's获取对象
        DCL_EX newInstance1 = declaredConstructor.newInstance();
        /*
         破坏加密：
            Field flag = DCL_EX.class.getDeclaredField("flag");
            flag.setAccessible(true);
            flag.set(newInstance1,false);
         */
        DCL_EX newInstance2 = declaredConstructor.newInstance();

        Field flag = DCL_EX.class.getDeclaredField("flag");
        flag.setAccessible(true);
        flag.set(newInstance1,false);
        //正常获取与反射获取的对象不同
        //System.out.println(dcl);
        System.out.println(newInstance1);
        System.out.println(newInstance2);
    }
}
