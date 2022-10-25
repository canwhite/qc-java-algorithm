package com.java.algorithm.hot100;

public class 跳跃游戏 {
    public static void main(String[] args) {
        
        /**
         * 思路很有意思：
         * 
         * 想象你是那个在格子上行走的小人，格子里面的数字代表“能量”，
         * 你需要“能量”才能继续行走。
         * 每次走到一个格子的时候，
         * 你检查现在格子里面的“能量”和你自己拥有的“能量”哪个更大，取更大的“能量”！
         * 如果你有更多的能量，你就可以走的更远啦！~
         * 
         */
        int[] nums = new int[]{2,3,1,1,4};
        boolean isEnd = canJump(nums);
        System.out.println(isEnd);



    }

    public static boolean canJump(int[] nums) {

        if(nums.length ==0){
            return true;
        }
        //初始能量和比较位置
        int cur = nums[0],i = 1;
        for(;cur!=0 && i<nums.length;i++){
            //随着走动能量要减少，
            //看格子能量是不是比当前持有能量大，做能量切换
            cur--;
            if(cur < nums[i]){
                cur = nums[i];
            }
        }
        return i == nums.length;
    }
    
}
