package com.java.algorithm.hot100;

public class 编辑距离 {
    public static void main(String[] args) {
        /**
         * 问题描述：
         * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
         * 你可以对一个单词进行如下三种操作：
         * 插入、删除、替换字符
         * 
         */

         /**
            输入：word1 = "horse", word2 = "ros"
            输出：3
            解释：
            horse -> rorse (将 'h' 替换为 'r')
            rorse -> rose (删除 'r')
            rose -> ros (删除 'e')
          */


        /**
         * 1.状态定义：
         * dp[i][j]表示word1的前i个字母转换成word2的前j个字母所使用的最少操作。
         * 
         * 2.状态转移
         * i指向word1，j指向word2
         * 若当前字母相同，dp[i][j] = dp[i-1][j-1]
         * 
         * 否则取增删替三个操作的最小值+1
         * dp[i][j] = min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1])+1
         */

        String word1 = "horse", word2 = "ros";
        int res = minDistance(word1, word2);
        System.out.println("---res---"+res);


    }
    public static int minDistance(String word1, String word2) {

        int len1 = word1.length(),len2 = word2.length();
        //初始化数组
        int[][] dp = new int[len1+1][len2+2];

        for(int i = 0; i<=len1; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j <= len2; j++){
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
    
}
