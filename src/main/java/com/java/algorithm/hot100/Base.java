package com.java.algorithm.hot100;

import java.util.ArrayList;
import java.util.Arrays;

public class Base {
    public static void main(String[] args) {
        //将array转化为list，可以增删改查的那种
        String[] strArray = new String[2];
        //（1）需要新建一个ArrayList实例，注意泛型和Array一致
        //（2）参数是Arrays.asList
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(strArray)) ;
        list.add("hello");
        System.out.println(list); 

    }
    
}
