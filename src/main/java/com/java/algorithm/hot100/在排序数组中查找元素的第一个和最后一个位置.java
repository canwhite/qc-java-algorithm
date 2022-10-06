package com.java.algorithm.hot100;

import java.util.Arrays;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        /** 
            给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
            请你找出给定目标值在数组中的开始位置和结束位置。

            如果数组中不存在目标值 target，返回 [-1, -1]。

            你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
            输入：nums = [5,7,7,8,8,10], target = 8
            输出：[3,4]
         */

        // 其实算法的本质，有点像是情况的分类分析，只是给了一些分析方法
        // 我可以理解这个问题为二分法加区间
        // 然后找区间的方法感觉有点笨啊，
        // 利用二分法先找左边界，再找右边界
        // 找左边界的时候由右侧逼近，
        // 找右边界的时候由左侧逼近，这样对之前的值有概念


        int[] nums = new int[]{
            5,7,7,8,8,10
        };
        int target = 8;
        int[] arr =  searchRange(nums, target);
        // System.out.println("--arr--" + arr);
        
        Arrays.stream(arr).forEach((item)->{
            System.out.println(item);
        });
        
        
    }
    public static int[] searchRange(int[] nums, int target) {

        int[] res = new int[] {-1, -1};
        //相当于加了一层条件去解决这个问题
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        return res;

    }
    //leftOrRight为true，找左边界，从右侧逼近，false找右边界，从左侧逼近
    public  static int binarySearch(int[] nums,int target,boolean leftOrRight){
        int res = -1;
        int left = 1, right = nums.length-1, mid ;
        while(left <= right){
            //我觉得这一行代码很有意思
            //这里有一个区间中点和整体中点的概念，
            //区间中点是现在的左侧，加上当前区间/2，得到的中点距离
            //整体中点比较简单，就是(left+right)/2就可以得到   
            mid = left + (right-left) /2;
            //没有找到target先找到target，找到target之后我们再做逼近，直到没有空间为止
            if(target < nums[mid])
                right = mid -1;
            else if(target > nums[mid])
                left = mid + 1;
            else{
                res = mid;
                //处理target === nums[mid]
                if(leftOrRight)
                    right = mid -1;
                else
                    left = mid + 1;
            }
        }
        return res;

    }


}
