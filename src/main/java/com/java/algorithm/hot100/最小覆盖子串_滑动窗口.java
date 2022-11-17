package com.java.algorithm.hot100;

import java.util.HashMap;
import java.util.Map;

public class 最小覆盖子串_滑动窗口 {
    public static void main(String[] args) {

        //寻找一个区间，可以理解为

        /**
         * 思路：
         * 1.注意到题目的关键："所有字母的最小子串"，也就是说两个串都只能是字母。
         * 
         * 2.于是，可以开辟一个大小为64的数组，来存放数组中字母的频率(Frequency)。准确的说，
         * 通过字母的ASCII码作为数组的索引，开辟空间的大小为26+6+26=58：26个大写字母，26个小写字母，
         * 还有中间的6个非字母  A~Z[65~90]  非字母[91~96]  a~z[97~122]
         * 
         * 3.滑动窗口的使用：分三种情况来移动窗口：（这里令当前窗口的左右边界分别为l，r，窗口的大小为winSize=r-l+1）
         * 1) 当winSize < t.size()  r++;  
         *      小于目标，明显是不行的，要尝试扩大，也就是窗口右边界向右移动
         * 2) 当winSize == t.size() :
         *      2.1) 当窗口中的字符已经符合要求了，直接返回return，已经找到了
         *      2.2) 否则r++，窗口右边界向右移动
         * 3) 当winSize > t.size()
         *      3.1) 当窗口中的字符已经符合要求了，l++，窗口左边界向右移动
         *      3.2) 否则r++，窗口右边界向右移动
         * 
         * 4. 上面是滑动窗口的使用思路，具体实现上有一定的不同，下面是需要考虑到的要点：
         *      1) 啥叫作窗口中的字符已经符合要求了？
         *      2) 窗口滑动时的操作是关键
         *      3) 要考虑到数组越界的问题
         *   
         */
        String s = "ADOBECODEBANC", t = "ABC";
        String res = minWindow(s, t);
        // System.out.println("--------"+res);
        System.out.println(res);


        
    }

    //minWindow
    public static String minWindow(String s, String t) {
        
        Map<Character,Integer> window = new HashMap<>();  // 用来记录窗口中的字符和数量
        Map<Character,Integer> need = new HashMap<>();    // 需要凑齐的字符和数量
        // 构建need字符集
        for (int i = 0; i < t.length(); i++) {
            char needChar = t.charAt(i);
            need.put(needChar,need.getOrDefault(needChar,0)+1);
        }

        int left = 0,right = 0,valid = 0;
        // valid是用来记录窗口中满足need要求的字符和数量的数目，比如need中要求字符a数量为2，如果window中的a字符的数量等于了2，valid就＋1，反之-1
        int len = Integer.MAX_VALUE;  // 记录最小字串的长度
        int start = 0;  // 记录最小字串的起始位置
        while(right < s.length()){
            char addChar = s.charAt(right);  // 即将要加入window的字符
            window.put(addChar,window.getOrDefault(addChar,0) + 1);  
            right++;
            // 如果加入的字符是need中要求的字符，并且数量已经达到了need要求的数量，则valid+1
            // 这里和下面都有个坑，window.get(addChar)和need.get(addChar)返回的都是对象，最好用.equals()方法比较大小
            if(need.containsKey(addChar) && window.get(addChar).equals(need.get(addChar))){
                valid++;
            }
			// 当window中记录的字符和数量满足了need中要求的字符和数量，考虑缩窗口
            // 以终为始
            while(valid == need.size()){
                // 先判断当前的最小覆盖字串是否比之前的最小覆盖字串短
                if(right - left < len){  // 注意，这里上面已经对right实施了++操作，所以这里的长度不是right - left + 1
                    len = right - left ;
                    start = left;  // 如果最短，则记录下该最小覆盖字串的起始位置
                }
                char removeChar = s.charAt(left);
                // 开始缩减窗口，left右移，如果要从window删除的字符正好是need中需要的并且，数目也等于need中需要的数目，则删减后，该该字符要求的数量
                // 显然不满足need要求的数量，所以valid要-1；
                if(need.containsKey(removeChar) && window.get(removeChar).equals(need.get(removeChar))){
                    valid--;
                }
                window.put(removeChar,window.get(removeChar) - 1);
                left++;
            }
        }
        // 如果最小覆盖字串的长度相对于定义时没变，则t不包含s中所有的字符，返回"",如果长度改变过，说明存在这样的最小覆盖字串，直接输出。
        return len == Integer.MAX_VALUE?"":s.substring(start,start+len);
    }
    
}
