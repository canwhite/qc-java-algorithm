package com.java.algorithm.hot100;

public class 爬楼梯_动规 {
    public static void main(String[] args) {
        /** 
        假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
        每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？


        输入：n = 2
        输出：2
        解释：有两种方法可以爬到楼顶。
        1. 1 阶 + 1 阶
        2. 2 阶
        */


        /**
         * 思路：
         * (1)确认dp数组以及下标的含义
         * 实际上dp[i]本身就是求解的结果，爬到第i层楼梯，有d[i]种方法
         * 
         * (2)确认递推公式
         * 明显是从左到右的一维数组，因为有一次一个台阶，和一次两个台阶的上法
         * 我们考虑d[i-1]和d[i-2]，
         * 首先是dp[i - 1]，上i-1层楼梯，有dp[i - 1]种方法，那么再一步跳一个台阶不就是dp[i]了么。
         * 还有就是dp[i - 2]，上i-2层楼梯，有dp[i - 2]种方法，那么再一步跳两个台阶不就是dp[i]了么。
         * 那么dp[i]就是 dp[i - 1]与dp[i - 2]之和！
         * 所以dp[i] = dp[i - 1] + dp[i - 2] 。
         * 
         * (3)关于初始化
         * dp[0] = 0 ; dp[0] = 1; 实际上都讲的通
         * 不考虑dp[0]如果初始化，只初始化dp[1] = 1，dp[2] = 2，
         * 然后从i = 3开始递推，这样才符合dp[i]的定义。
         * 
         * (4)关于递推顺序
         * 从前往后递推
         * 
         */
        int n = 4;
        int res =  climbStairs(n);
        System.out.println(res);


        
    }
    public static int climbStairs(int n) {
        if(n <= 1 )return n; //因为下边直接对dp[2]操作了
        int[] dp = new int[n+1]; //为什么要+1啊，如果是2，因为我们有index = 0的情况
        //爬楼梯的时候可以不计0，就从1，2开始
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<=n;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    
}
