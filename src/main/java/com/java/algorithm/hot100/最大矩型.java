package com.java.algorithm.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

public class 最大矩型 {
    public static void main(String[] args) {
        /**
         *  
         * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，
         * 找出只包含 1 的最大矩形，并返回其面积。
         * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
         * 输出：6
         */
        /**
         1  0   1   0   0
         1  0   1   1   1
         1  1   1   1   1
         1  0   0   1   1
         */
        /** 
        以下思路联系柱状图最大矩型去做，相当于把二维问题变成一维问题
        分层去算最大面积
        第一层柱状图的高度["1","0","1","0","0"]，最大面积为1；
        第二层柱状图的高度["2","0","2","1","1"]，最大面积为3；
        第三层柱状图的高度["3","1","3","2","2"]，最大面积为6；
        第四层柱状图的高度["4","0","0","3","0"]，最大面积为4；
        
        */



    }
    
    public static int maximalRectangle(char[][] matrix) {
        //如果行或者列为0，则返回为0
        if(matrix.length ==0 || matrix[0].length ==0){
            return 0;
        }
        //得到行列
        int row = matrix.length;
        int col = matrix[0].length;

        //维系一个一维的数组
        int[] heights = new int[row];
        int ans = 0; //维护一个结果集

        //双层for循环
        for(int i = 0; i < row;i++){
            for(int j = 0; j< col; j++){
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            //求和
            ans = Math.max(ans, largestRectangleArea(heights));
        }

        //返回结果
        return ans;
    }


    /**
     * 柱状图中最大矩型
     * 
     */

    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) {
            new_heights[i] = heights[i - 1];
        }
        ;
        for (int i = 0; i < new_heights.length; i++) {
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }
}
