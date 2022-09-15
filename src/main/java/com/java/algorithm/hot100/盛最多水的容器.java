package com.java.algorithm.hot100;


/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    返回容器可以储存的最大水量。
    说明：你不能倾斜容器。
    输入：[1,8,6,2,5,4,8,3,7]
    输出：49 
    解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

 */
public class 盛最多水的容器 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int res = maxArea(height);
        System.out.println("--res:"+res);
        
    }
    public static int maxArea(int[] height) {

        //左右指针
        int size = height.length;
        int left = 0, right = size-1;
        int ans = 0;
        //左右指针这种算面积的还可以直接left < right来处理
        while(left < right){
            //底乘高，然后保留比较大的值
            ans =Math.max(ans, (right - left)*Math.min(height[left], height[right]));
            /** 
             * 这种情况下我们想要让指针移动后的容器面积增大，就要使移动后的容器的高尽量大，
             * 所以我们选择指针所指的高较小的那个指针进行移动，
             * 这样我们就保留了容器较高的那条边，放弃了较小的那条边，以获得有更高的边的机会。
             */
            if(height[left] > height[right]){
                right -- ;
            }else{
                left ++;
            }
        }
        //返回数据
        return ans;
    }
    
}
