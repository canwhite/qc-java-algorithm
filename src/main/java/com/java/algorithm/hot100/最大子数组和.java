package com.java.algorithm.hot100;

public class 最大子数组和 {
    public static void main(String[] args) {
        /**
         * 给你一个整数数组 nums ，
         * 请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），
         * 返回其最大和。
         * 子数组 是数组中的一个连续部分。
         */

        /**
         * 思路：
         * 该算法更为简便之处是忽略了对子序列的寻找比较,而是根据规律直接找出最佳答案.
         * 对于含有正数的序列而言,最大子序列肯定是正数,
         * 所以头尾肯定都是正数.我们可以从第一个正数开始算起,
         * 每往后加一个数便更新一次和的最大值;当当前和成为负数时,
         * 则表明此前序列无法为后面提供最大子序列和,
         * 因此必须重新确定序列首项.
         */
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(nums);
        System.out.println(res);



    }

    public static int maxSubArray(int[] nums) {
        //res相当于初始化一个值
        int res = nums[0];
        //求一个和
        int sum = 0;

        for(int num : nums){
            if(sum > 0){
                sum += num;
            }else{
                sum = num;//为负数时，相当于重新确认了序列首项
            }
            //然后给res阶段值，每次都算
            //res相当于一个缓存
            res = Math.max(res, sum);
        }
        return res;
    }
    
}
