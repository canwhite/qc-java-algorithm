package com.java.algorithm.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//
public class 字母异位词分组_map {
    public static void main(String[] args) {
        /**
         * 给你一个字符串数组，请你将 字母异位词 组合在一起。
         * 可以按任意顺序返回结果列表。
         * 字母异位词是由重新排列源单词的字母得到的一个新单词，
         * 所有源单词中的字母通常恰好只用一次。
         */

        /**
         * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
         * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
         * nat，tan是相同的三个char组成的，只是顺序不同，这叫异位词
         */
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagrams(strs);
        list.stream().forEach(item->{
            System.out.println(item.toString());
        });
    }
    public static  List<List<String>> groupAnagrams(String[] strs) {
        //用map来解决问题
        //map用来标记已有特别好用，所以在任意分组的时候很有用
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(String s:strs){
            //先转化为charArr来进行操作
            char[] ch = s.toCharArray();
            Arrays.sort(ch); //这是为了把异位词打平，重新排序作为key
            //然后在转化成String作为key
            String key = String.valueOf(ch);
            //如果之前没有对应key的数组，就新建一组键值对
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());   
    }
}


