package com.java.algorithm.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

public class 柱状图最大的矩形_单调栈 {
    public static void main(String[] args) {
        /**
         * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
         * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
         */


        /**
         先看一种理解
         看了别人的答案想了半天才明白……其实可以把这个想象成锯木板，如果木板都是递增的那我很开心，
         如果突然遇到一块木板i矮了一截，那我就先找之前最戳出来的一块（其实就是第i-1块），
         计算一下这个木板单独的面积，然后把它锯成次高的，
         这是因为我之后的计算都再也用不着这块木板本身的高度了。
         再然后如果发觉次高的仍然比现在这个i木板高，
         那我继续单独计算这个次高木板的面积（应该是第i-1和i-2块），再把它俩锯短。
         直到发觉不需要锯就比第i块矮了，那我继续开开心心往右找更高的。
         当然为了避免到了最后一直都是递增的，所以可以在最后加一块高度为0的木板。
         这个算法的关键点是把那些戳出来的木板早点单独拎出来计算，
         然后就用不着这个值了。说实话真的很佩服第一个想出来的人……
         */

        /**
         * 单调递增栈，大数往下沉，栈顶是小的
         * 单调递减栈，小数字往下沉，栈顶是大的
         *
         */





    }

    //
    public static int largestRectangleArea(int[] heights) {

        int ans = 0; //预置一个结果集

        //这里为了代码简便，在柱体的数组的头和尾加了两个高度为0的柱体
        int[] tmp = new int[heights.length+2];
        //copy heights的值
        System.arraycopy(heights, 0, tmp, 1, heights.length);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < tmp.length; i++) {
            int item = tmp[i]; //(item,index)=>{}
            //栈顶比较大的
            while(!stack.isEmpty() && tmp[stack.peek()] > item){

            }






            
        }












        return 0;

    }




}
