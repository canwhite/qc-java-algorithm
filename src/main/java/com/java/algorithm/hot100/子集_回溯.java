package com.java.algorithm.hot100;

import java.util.ArrayList;
import java.util.List;

public class 子集_回溯 {

    //用来收集最终结果
    static List<List<Integer>> res = new ArrayList<>();
    //用来收集单个子集，可以反复使用，用后回溯
    static List<Integer> helper = new ArrayList<>();


    public static void main(String[] args) {
        /**
         * 给你一个整数数组 nums ，数组中的元素 互不相同 。
         * 返回该数组所有可能的子集（幂集）。
         * 解集不能包含重复的子集。你可以按任意顺序返回解集。
         * 
         * 输入：nums = [1,2,3]
         * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
         */

        
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> data = subsets(nums);
        System.out.println(data);



    }
    //子集方法
    public static List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return res;
    }
    //回溯方法
    public static void backtracking(int[] nums ,int index){
        
        res.add(new ArrayList<>(helper));
        //如果index=3;尽多回退两次到横向循环部分，也就你是会退两次，到index=1;
        if(index > nums.length){
            return;
        }
        for(int i = index; i < nums.length ;i++){
            //index = 0;
            helper.add(nums[i]);
            // System.out.println("----"+index + ":"+ nums[i]+"----");
            backtracking(nums, i+1); //
            helper.remove(helper.size()-1);//洋葱圈
 
        }
    }



}
