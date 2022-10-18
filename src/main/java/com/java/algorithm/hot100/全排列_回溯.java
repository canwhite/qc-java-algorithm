package com.java.algorithm.hot100;

import java.util.ArrayList;
import java.util.List;

public class 全排列_回溯 {
    public static void main(String[] args) {
        /**
         * 给定一个不含重复数字的数组 nums ，
         * 返回其 所有可能的全排列 。
         * 你可以 按任意顺序 返回答案。
         * 输入：nums = [1,2,3]
         * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
         */

        /*
        这个我们可以直接按照公式走
        result = []
        //也可以在这里加一个结果参数
        def backtrack(路径, 选择列表):
            if 满足结束条件:
                result.add(路径)
                return
            
            for 选择 in 选择列表:
                做选择
                backtrack(路径, 选择列表)
                撤销选择
         */

         //实际上回溯套公式就可以了
         int[] nums = {1,2,3};
         List<List<Integer>> result = permute(nums);
         System.out.println(result.toString());

    }

    public static List<List<Integer>> permute(int[] nums) {
        //先创建一个结果数组  
        List<List<Integer>> res = new ArrayList<>();
        //再创建一个路径数组
        List<Integer> list = new ArrayList<>();
        //最后是选择列表  
        backtrack(res, list, nums);
        return res;
    }

    public static void backtrack(List<List<Integer>> res ,List<Integer> list,int[] nums ){
        //判断满足结果条件
        //map和list是size，array取得是length属性，String取的是length()
        if(list.size() == nums.length){
            //添加结果，
            //这里不是直接添加list，而是把满足的list copy出来一份
            res.add(new ArrayList<>(list));
            return;
        }
        //然后遍历选择列表，先横向跑
        for(int num : nums){
            //做个减枝，如果不包含了才往下走
            if(!list.contains(num)){
                //做出选择
                list.add(num);
                //递归往下
                backtrack(res, list, nums);
                //回溯
                list.remove(list.size()-1);
            }
        }
    }


    
}
