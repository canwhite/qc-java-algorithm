package com.java.algorithm.hot100;

public class 最小路径和_基础动规up {
    public static void main(String[] args) {
        /**
         * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
         * 说明：每次只能向下或者向右移动一步。
         * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
         * 输出：7
         * 解释：因为路径 1→3→1→1→1 的总和最小。
         */

         /**
          * 看到了m*n，同样可以理解为动规问题
          * 甚至连初始化都不用，只是情况要多维度判断
          * (1)首先dp[i][j]表示当前位置的和
          * (2)递推公式 因为除了路径，还要装值，所以分为起点、左边缘、上边缘、一般情况来分开计算
          * (3)递归顺序，从左到右，从上到下
          * (4)初始值为0
          * 类似一个01背包问题，怎么装装最多
          * 一会儿再看下01背包的概念吧
         */

        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int res = minPathSum(grid);
        System.out.println("---res----" + res);
        

        

    }
    
    public static int minPathSum(int[][] grid) {

        //创造一个dp数组吧，将dp当作一个背包
        int[][] dp = new int[grid.length][grid[0].length];

        for(int i = 0 ;i < grid.length ; i++){
            for(int j = 0; j< grid[0].length ; j++){   
                //在起点的时候
                if(i == 0 && j == 0){
                    dp[i][j] = grid[0][0];
                }
                //在左边缘的时候
                if(j == 0 && i != 0){
                    dp[i][j] = dp[i - 1][j]  + grid[i][j];
                }
                //在上边缘的时候
                if(i == 0 && j != 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }
                //普遍情况下,要考虑左侧和上侧
                if(i != 0 && j != 0){
                    //从左边和右边选一个比价小的，然后加上下个背包
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[grid.length-1][grid[0].length -1];
    }
}
