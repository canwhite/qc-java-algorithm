package com.java.algorithm.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并区间_排序 {
    public static void main(String[] args) {
        /** 
        以数组 intervals 表示若干个区间的集合，
        其中单个区间为 intervals[i] = [starti, endi] 。
        请你合并所有重叠的区间，并返回 一个不重叠的区间数组，
        该数组需恰好覆盖输入中的所有区间 。

        输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        输出：[[1,6],[8,10],[15,18]]
        解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
        */

        //合并区间牵涉到排序问题
        //抽空复习一下快排吧
        //今天复习了一下，大致是基准，左右和递归
        

        /**
         * 这道题目本身的思想并不太难, 我们很自然地想到如果
         * 区间是从小到大的顺序排列好, 
         * 那么通过比较相邻两个区间的大小就可以将它们进行合并
         * 实际上有些时候贪心算法，直接按逻辑思考就可以了
         */


        int[][] list = new int[][]{{2,6},{1,3},{8,10},{15,18}};
        int[][] res =  merge(list);
        Arrays.stream(res).forEach(item->{
            System.out.println(item[0]+":" + item[1]);
        });





    }



    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 0 ){
            return new int[0][2];//返回默认0的数组
        }
        //会将   {{2,6},{1,3},{8,10},{15,18}}
        //转化为 {{1,3},{2,6},{8,10},{15,18} 比较第一个数据的大小
        //然后再排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        
        //建立集合, 用来存储所有区间, int[] 就代表一个区间
        List<int[]> list = new ArrayList<>();
        //加入第一个个区间
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            //如果答案区间集合中最后一个的最右端小于当前要添加的最左端, 添加到答案区间集合不合并
            if (list.get(list.size() - 1)[1] < intervals[i][0]) {
                list.add(intervals[i]);
            }else {//如果答案区间最右端大于当前区间的最左端, 判断是否合并为一个区间
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
            }
        }
        //toArray里边的内容是撑出空间
        //这是一种将list转化为array的方法
        return list.toArray(new int[list.size()][]);
    }
}
