package com.java.algorithm.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseType {
    public static void main(String[] args) {
        //java的基础数据类型
        /** 
         * 基础类型及其包装类
         * btye-Byte，char-Character,short-Short,float-Float
         * int-Integer,double-Double,long-Long,boolean-Boolean
        */


        /** 
         * toString
         * 也就是常用的包装类和封装的高级类型，toString已经重写了
         * 基础数据类型和Array并没有重写
        */
        
        Integer n = 1;
    
        System.out.println(n.toString());

        //List和常用包装类，重写了toString方法，基础数据类型并不是类，所以没有toString
        List<Integer> list = new ArrayList<>();
        list.add(n);
        System.out.println(list.toString());
        
        

        //数组没被重写toString继承自Object的toString
        Integer[] array = new Integer[]{1,2,3};
        System.out.println(array.toString());
        //但是Arrays工具类上，重写的有，我们可以使用Arrays.toString来实现这一效果
        System.out.println(Arrays.toString(array));
        Arrays.stream(array).forEach(item->{
            System.out.println(item);
        });


        /**
         * equals 
         * 那是因为Object类中的equals方式是比较两个对象的地址！
         * 虽然person1和person2中的成员变量值相同，但是这两个对象（引用）所指向的地址不一样，
         * 所以equals就判断为false
         * 如果要比较，相关的类需要重写equals，唯一不需要重写的是String类
         */


         Integer n1 = new Integer(1);
         Integer n2 = new Integer(2);
         System.out.println(n1.equals(n2));


         String s1 = "123";
         String s2 = "123";
         System.out.println(s1.equals(s2));
        

    
    }
    
}
