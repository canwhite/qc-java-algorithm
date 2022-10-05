package com.java.algorithm.hot100;

public class 搜索旋转排序数组 {
    public static void main(String[] args) {
        /**
            整数数组 nums 按升序排列，数组中的值 互不相同 。
            在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
            例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
            给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
            你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。

            输入：nums = [4,5,6,7,0,1,2], target = 0
            输出：4

            思路，看到logn应该想到二分法，具体就是二分法的实现了
            
         */

        int[] nums = {
            4,5,6,7,0,1,2
        };
        int index =  search(nums, 0);
        System.out.println("index:" + index);

    }
    public static int search(int[] nums, int target) {
        /** 
         * 如果中间的数小于最右边的数，则右半边是有序的
         * 若中间的数大于右边的数，则左半边是有序的
         * 我们只要在有序的半段里用首尾两个值来判断目标值是否在这一区域内
         * 这样就可以确定保留哪半边了
         */
        int len = nums.length;
        int left = 0, right = len-1;
        //它这种应该是左实右实的思路，right=len-1
        //判断不是更换左右节点的时候主要也是+1,-1
        while(left <= right){
            //求得中间
            int mid = (left + right)/2;
            //先判断中间，如果满足就返回
            if(nums[mid] == target) return mid;
            if(nums[mid] < nums[right]){
                //判断target在不在这个区间
                if(nums[mid] < target && target <= nums[right])
                    //这种说明在右边
                    left = mid +1;
                else
                    right = mid-1;
            }
            if (nums[mid] > nums[right]){
                if(nums[left] <= target && target < nums[mid])
                    right = mid -1;
                else 
                    left = mid + 1;
            }
            
        }
        return -1;
    }

}
