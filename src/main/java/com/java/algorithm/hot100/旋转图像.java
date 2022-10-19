package com.java.algorithm.hot100;
// import java.util.Arrays;

// import java.lang.System.Logger;
import java.util.Arrays;

public class 旋转图像 {
    public static void main(String[] args) {
        /**
         * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。
         * 请你将图像顺时针旋转 90 度。
         * 你必须在 原地 旋转图像， 这意味着你需要直接修改输入的二维矩阵。
         * 请不要 使用另一个矩阵来旋转图像。
         * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
         * 输出：[[7,4,1],[8,5,2],[9,6,3]]
         */

         /** 
          * 转置 : 横向第一排转化为纵向第一排，依次类推
          * 镜像 : 左边的到右边，或者右边的到左边
          * 九十度 : 先转置，再左右
          * 二百七十度 ：先转置，再上下
          * 一百八十度 ：先上下，再左右
          */
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
         


    }

    public static void rotate(int[][] matrix) {
        //先拿到size
        int matrixSize = matrix.length;
        
        //先转置矩阵
        for(int i = 0 ; i< matrixSize; i++){
            //j<i等于是把左下角的内容转换到右上角
            for(int j = 0 ; j < i; j++){
                //交换
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //再左右镜像，将左边的换到右边
        int left = 0;
        int right = matrixSize-1;
        //左右颠倒是第一列到第三列，left/right取j值
        //上下颠倒是第三行到第一行，left/right取i值
        //i是一个个的子树组
        while(left < right){
            for(int i = 0; i< matrixSize ; i++){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
            }
            left ++;
            right --;
        }

        for(int i = 0; i<matrixSize;i++){
            Arrays.stream(matrix[i]).forEach(item->{
                System.out.println(item);
            });
        }
    }



    



    
}
