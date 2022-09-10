package com.java.algorithm.hot100; //会自动创建包

import java.util.HashMap;

public class 两数之和 {

    public static void main(String[] args) {
        int[] nums =  {2,7,11,15};
        int target = 9;
        int[] res = twoSum(nums,target);
        // System.out.println(res + "") ;
        for (int i : res) {
            System.out.println(i);
        }
    }

    //确定两数之和
    public static int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        if(nums == null || nums.length ==0){
            return  res;
        }
        //建立k-v，一一对应的hash表
        HashMap<Integer,Integer> map = new HashMap<>();
        //判断元素是否出现，map中的存储结构为 {key：数据元素，value：数组元素对应的下表}。 
        for(int i = 0;i < nums.length ; i++){
            //判断差值
            int temp = target - nums[i];
            //这个差值之前是否遍历过,那就找到了，返回
            if(map.containsKey(temp)){
                res[1] = i;//那么i应该是返回的后边的一个
                res[0] = map.get(temp);
            }
            //如果没有找到，就你只是记录,key为值，value为index
            map.put(nums[i], i);
        }        
        return res;
    }    
}
