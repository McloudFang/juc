package com.example.juc.singleton;

import java.lang.reflect.Constructor;

/**
 * enum 也是个class
 *
 * Cannot reflectively create enum objects
 * 无法反射性地创建枚举对象
 */
public enum Enum_t {
    INSTANCE;
    private Enum_t getInstance(){
        return INSTANCE;
    }
}

class Test{
    public static void main(String[] args) throws Exception {
        //
        Enum_t instance1 = Enum_t.INSTANCE;
        Constructor<Enum_t> declaredConstructor = Enum_t.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        Enum_t instance2 = declaredConstructor.newInstance();
        System.out.println(instance1);
        System.out.println(instance2);
    }
}
