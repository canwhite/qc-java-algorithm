package com.java.algorithm.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/** 
给你一个整数数组 nums ，
判断是否存在三元组 [nums[i], nums[j], nums[k]] 
满足 i != j、i != k 且 j != k ，
同时还满足 nums[i] + nums[j] + nums[k] == 0 。
请你返回所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。
 */
public class 三数之和_左右指针 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>>  res = threeSum(nums);
        System.out.println(res);

    }

    /**
     * 实际上是一种左右指针，因为是三数之和，
     * 所以左边放两个，
     * */
    public static List<List<Integer>> threeSum(int[] nums) {

        /**
         * 思路：
         * 拿这个nums数组来举例，首先将数组排序，然后有一层for循环，
         * i从下标0的地方开始，同时定一个下标left 定义在i+1的位置上，定义下标right 在数组结尾的位置上。
         * 依然还是在数组中找到 abc 使得a + b +c =0，
         * 我们这里相当于 a = nums[i]   b = nums[left]    c = nums[right]。
         * 接下来如何移动left 和right呢， 如果nums[i] + nums[left] + nums[right] > 0 就说明 此时三数之和大了，
         * 因为数组是排序后了，所以right下标就应该向左移动，这样才能让三数之和小一些。
         * 如果 nums[i] + nums[left] + nums[right] < 0 说明 此时 三数之和小了，
         * left 就向右移动，才能让三数之和大一些，直到left与right相遇为止。
         */

         //创建结果数组和对现有数组进行排序
         List<List<Integer>>  result = new ArrayList<>();
         Arrays.sort(nums);

         //找出a+b+c=0; a = nums[i], b = nums[left], c = nums[right]
         for(int i = 0; i < nums.length ; i++){
            //排序之后如果第一个值大于0了，那么无论如何组合是不可能凑成三元组，直接返回结果就可以了
            if(nums[i] > 0){
                return result;
            }

            // 错误去重方法，将会漏掉-1,-1,2 这种值的组合情况
            /*
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            */
            //去重
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;

            //左右指针一种很常用的方法是判断right > left，
            //然后两边加加减减
            while(right > left){
                /*
                    // 去重复逻辑如果放在这里，0，0，0 的情况，可能直接导致 right<=left 了，从而漏掉了 0,0,0 这种三元组
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                */
                if(nums[i] + nums[left] + nums[right] > 0){
                    right --;
                }else if(nums[i] + nums[left] + nums[right] < 0){
                    left ++; 
                }else{
                    //添加结果元素,因为里边也是list，所以我们对现有的list进行一些改造 
                    result.add(Arrays.asList(nums[i],nums[left],nums[right])); //添加一个result结果
                    //左右去重复，减少一些重复查询的量
                    while(right > left && nums[right] == nums[right -1]) right --; 
                    while(right > left && nums[left] == nums[left + 1]) left ++;
                    
                    right --;
                    left ++;   
                }
            }
         }
        return result;
    }
    
}
