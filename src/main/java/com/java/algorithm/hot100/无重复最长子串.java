package com.java.algorithm.hot100;

import java.util.HashSet;
import java.util.Set;

public class 无重复最长子串 {

    public static void main(String[] args) {
        String s =  "abcabcbb";
        int num = lengthOfLongestSubstring(s);
        System.out.println(num);    
    }

    public static int  lengthOfLongestSubstring(String s) {
        //维护当前最长不重复字符串
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while(right < s.length()){
            if(!set.contains(s.charAt(right))){
                //未查到重复字段就一直加，right右移
                set.add(s.charAt(right));
                right ++;
            }else{
                //right查到重复字段就先不动，
                //left右移，从set中删除left经过的字符
                //直到重复的这个字符删掉为止
                set.remove(s.charAt(left));
                left ++;
            }
            //每次计算当前set子串的长度
            max = Math.max(max, set.size());
        }
        return max;
    }
}
