package com.java.algorithm.hot100;
/** 
 * 所谓回文，就是正念和反念都一样
 * 上海自来水来自海上
 */
public class 最长回文子串_动规 {
    public static void main(String[] args) {
        String s =  longestPalindrome("babad");
        System.out.println(s);
        
    }
    /** 有一本书叫做《代码随想录》，我最早起步的时候用得就是它
     * 它介绍了两种解法
     * 1.递推公式
     * 2.双指针法，另外一题，无重复最长子串，用得也是双指针法
     */
    public static String longestPalindrome(String s) {
        /** 
         * 大致动规的解题步骤：
         *  (1)确定dp数组（dp table）以及下标的含义
         *  (2)确定递推公式
         *  (3)确定数组如何初始化
         *  (4)确定递推顺序
         *  (5)举例推导
         */
        //创建一个二维数组
        char[] a = s.toCharArray(); 
        int len = a.length;
        //(1)dp数组及下标含义
        //布尔类型的dp[i][j]：
        //表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
        int[][] dp = new int[len][len];
        
        //(2)初始化，默认是false的，所以给0
        for(int i = 0; i< dp.length;i++){
            for(int j = 0;j < dp.length; j++){
                dp[i][j]=0;
                //System.out.println(dp[i][j]);
            }
        }
        //java中的几个长度
        //数组 ： length
        //字符串 ： length()
        //集合  ：  size();
        int maxLength = 0;
        int left = 0;
        int right = 0;

        //递推顺序和递推公式
        //i是从下到上
        for(int i = len-1 ; i>=0 ;i--){
            //j是从左到右，而且j因为区间[i,j]原因是比i大的，当然也可能相等
            for(int j = i ;j < len; j++){
                /**
                 * 递推公式：
                 * 整体上是两种，就是s[i]与s[j]相等，s[i]与s[j]不相等这两种。

                    当s[i]与s[j]不相等，那没啥好说的了，dp[i][j]一定是false。

                    当s[i]与s[j]相等时，这就复杂一些了，有如下三种情况

                        情况一：下标i 与 j相同，同一个字符例如a，当然是回文子串
                        情况二：下标i 与 j相差为1，例如aa，也是文子串
                        情况三：下标：i 与 j相差大于1的时候，例如cabac，
                               此时s[i]与s[j]已经相同了，
                               我们看i到j区间是不是回文子串就看aba是不是回文就可以了，
                               那么aba的区间就是 i+1 与 j-1区间，
                               这个区间是不是回文就看dp[i + 1][j - 1]是否为true。
                 */
                if(a[i] == a[j]){
                    //情况一和情况二
                    if(j-i <= 1){
                        dp[i][j] = 1;
                    }else if(dp[i + 1][j - 1] == 1){
                        dp[i][j] = 1;
                    }
                }

                //更新左右和最大长度
                if(dp[i][j] == 1  &&  j-i+1 >maxLength){
                    maxLength = j-i+1;
                    left = i;
                    right = j;
                }
            }
        }
        System.out.println(left + ":" + right);
        //subSring主要是左闭右开了，所以要加一个
        return s.substring(left, maxLength+1);
    }

}
