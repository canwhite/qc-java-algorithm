package com.java.algorithm.hot100;

public class 两个正序数组的中位数 {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};      
        double result = findMedianSortedArrays(nums1, nums2) ;
        System.out.println(result);
        
    }

    /** 注意时间复杂度要求m+n */
    /** 
     * 回顾一下中位数的定义，
     * 如果某个有序数组长度是奇数，
     * 那么其中位数就是最中间那个，如果是偶数，那么就是最中间两个数字的平均值。
     * 
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m+n+1)/2;
        int right = (m+n+2)/2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }
    // 第二个和第四个参数，i和j分别为nums1和nums2的起始位置，这是为了不新建数组
    // 最后一个k是我们模拟的nums1和nums2的k的位置
    public static int findKth(int[] nums1,int i ,int[] nums2,int j ,int k){
        //如果数组为空，那么从另外一个数组去找，直接就能找出来
        if( i >= nums1.length) return nums2[j + k -1];//如果nums1为空
        if( j >= nums2.length) return nums1[i+ k-1]; //如果nums2为空数组
        //如果key==1，
        if(k == 1){
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        //为的是往中间挪
        if(midVal1 < midVal2){
            return findKth(nums1, i + k / 2, nums2, j , k - k / 2);
        }else{
            return findKth(nums1, i, nums2, j + k / 2 , k - k / 2);
        }  
    } 
}
