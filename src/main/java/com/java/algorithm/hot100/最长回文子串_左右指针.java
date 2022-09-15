package com.java.algorithm.hot100;
public class 最长回文子串_左右指针 {

    /**
     * 首先确定回文串，就是找中心然后想两边扩散看是不是对称的就可以了。
     * 一个元素可以作为中心点，两个元素也可以作为中心点。
     */

    public static void main(String[] args) {
        
        String s =  longestPalindrome("babad");
        System.out.println(s);
    }
    
    public static String longestPalindrome(String s) {

        //如果为null，返回空字符串
        if(s == null || s.length() == 0 ){
            return "";
        }
        //保存起止位置，测试数组似乎比全局变量更快一点
        int[] range = new int[2];
        //将字符串转化为char数组
        char[] str = s.toCharArray();
        for(int i = 0;i< s.length();i++){
            //把回文看作中间的部分全是同一字符，左右部分相对称
            //找到下一个和当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);

    }

    public static int findLongest(char[] str, int low, int[] range) {
        //双指针法特别适合使用while，左右指针可以循环俩值，快慢指针可以循环一个值，注意条件，方便跳出
        //(1)查找中间部分，它可能是一个区间
        int high = low;
        while(high < str.length-1 && str[high+1] == str[low]){
            high ++;
        }   
        //(2)定位中间部分的最后一个字符
        //等出来时候又加了一个，其实上已经是相等字符的下一个不等字符了
        //将这个字符作为下一次递归的起点
        int ans = high;

        //(3)从中间向两侧扩散
        while(low > 0  && high < str.length -1 && str[low-1] == str[high + 1]){
            low --;
            high ++;
        }
        //(4)记录最大长度
        if(high - low > range[1] -range[0]){
            range[0] = low;
            range[1] = high;
        }

        return ans;

    }

}
