package com.java.algorithm.hot100;

public class 下一个排列 {
    public static void main(String[] args) {
        /**
         * 给你一个整数数组 nums ，找出 nums 的下一个排列。
         * 必须 原地 修改，只允许使用额外常数空间。
         *  示例 1：

                输入：nums = [1,2,3]
                输出：[1,3,2]
            示例 2：

                输入：nums = [3,2,1]
                输出：[1,2,3]
         */

         int[] nums = {1,2,3};
         nextPermutation(nums);
         for (int i : nums) {
            System.out.println(i);
         }
    }

    public static void nextPermutation(int[] nums) {
        //求一个字典序更大的排列，都是倒叙，但是j比i大，然后方
        for(int i = nums.length-1; i>=0 ;i--){
            //然后在里边走j，j在i的后边，所以这里使用j>i
            for(int j = nums.length-1; j>i;j++){
                if(nums[j] > nums[i]){
                    //swap
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    //然后将i后边的顺序重排
                    //nums.length-1的意思是，reverse的end是下标，所以搞清楚长度和下标的区别
                    reverse(nums,i+1,nums.length-1);
                    return; //找到下一个就可以，所以这里return
                }
            }
        }
        //到这里说明整个数组都是倒序了，
        reverse(nums, 0, nums.length-1);

    }

    //这里加一个整体颠倒的写法
    public static void reverse(int[] arr,int begin,int end){
        /**
         * 这块儿很有意思，
         * 它整体是分成三段， 初始化、判断、步骤操作；
         * 每一段都是分号隔开
         * 但是单个一段里，可以用逗号设置多个
         */
        for(int left = begin,right = end;left <= right;  left++,right-- ){
            int temp = arr[left]; //先缓存左值
            //将右值给到左
            arr[left] = arr[right];
            //将缓存值给到右
            arr[right] = temp;
        }
    }


}
