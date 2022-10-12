package com.java.algorithm.hot100;

import java.util.Stack;

public class 接雨水_单调栈 {
    public static void main(String[] args) {

        /**
         * 关于单调栈
         * 单调栈就是比普通的栈多一个性质，即维护一个栈内元素单调
         * 比如当前某个单调递减的栈的元素从栈底到栈顶分别是：[10, 9, 8, 3, 2]，
         * 如果要入栈元素5，需要把栈顶元素pop出去，
         * 直到满足单调递减为止，即先变成[10, 9, 8]，
         * 再入栈5，就是[10, 9, 8, 5]。
         * 如果是具像化理解的话，就是先将右侧的给拔出，然后再push上5

         */

        /*
         * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
         * 计算按此排列的柱子，下雨之后能接多少雨水。
         *  输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
            输出：6
            解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
            可以看该题链接，上边有图
          
         */

        /**
         *  思路一
         *  1. 找到最高点
         *  2. 分别从两边往最高点遍历：如果下一个数比当前数小，说明可以接到雨水
         * 
         *  思路二
         *  还有一种单调栈的思路我们可以考虑下，
         *  我记得有一个括号的，也是出于这样的思路
         * 
         */

        int[] trips = new int[]{4, 3, 1, 0, 1, 2, 4};
        int ans = trap(trips);
        System.out.println(ans);





        
    }

    /** 
     * peek和pop都返回栈顶的值
     * 不同点在于：peek不动原栈，而pop删除栈顶值
     */

    public static int trap(int[] height) {
        
        if(height.length == 0){
            return 0;
        }
        //创建栈对象
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i = 0 ;i < height.length ; i++){
            //height[stack.peek()] < height[i] 
            //注意的是单调栈的原理，栈内元素单调递增或者递减
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                //pop的是比当前值小的值，方便新值插入
                int curIdx = stack.pop();
                System.out.println("curIdx"+curIdx);
                //如果有连续相等的值继续吐出
                while(!stack.isEmpty() && height[stack.peek()] == height[curIdx] ){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    //stack是变化之后
                    int stackTop = stack.peek();//这种情况不删除只是取
                    System.out.println("stackTop"+stackTop);
                    //ans做的是一个求和,较小的那个才能储到水
                    // stackTop此时指向的是接住雨水的左边界的位置。右边界是当前的柱体，即i
                    // Math.min(height[stackTop],height[i])是左右柱子高度的min，减去height[curIndex]就是雨水的高度
                    ans += (Math.min(height[stackTop], height[i]) -height[curIdx]) * (i - stackTop -1);

                }
            }
            stack.add(i);
        }
        return ans;
    }
    
}
