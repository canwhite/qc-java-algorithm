package com.java.algorithm.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAndList {
    public static void main(String[] args) {


        
        /**
         *  一、array转list 
         * */
        String[] strArray = new String[2];
        //（1）需要新建一个ArrayList实例，注意泛型和Array一致
        //（2）将Arrays.asList作为参数传入参创建list
        // PS:直接对一个数组调用asList转的list不能add
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(strArray)) ;
        list.add("hello");
        System.out.println(list); 

        /** 
         * 二、List转array
         */
        // (1)toArray如果不加参数转化出来的是Object[],
        // (2)注意基本类型是不能作为泛型参数的。如果是使用int[] 类型数组，需要把 int[] 换成 Integer[] 
        List<Integer> nlist = new ArrayList<>();
        nlist.add(1);
        nlist.add(2);
        nlist.add(3);
        Integer[] array =  nlist.toArray(new Integer[list.size()]); 
        System.out.println(array);


        /** array ,list,map,string如何获取长度
         *  1.list和map这种封装度高的是size()
         *  2.array是length属性
         *  3.string是length方法
         */

            /** new ArrayList可以接收两种参数
             * 一个是数量，可以先确定大小
             * 一个是Collection，可以根据集合顺序新建list
             * 再进一步思考一下，Array好像也是这样，针对第二项，int[]{字面量},区别于参数传入
             */
            // ans.add(new ArrayList<>(list));
   

    }
    
}
