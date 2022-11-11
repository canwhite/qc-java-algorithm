package com.java.algorithm.hot100;

import java.util.Arrays;

public class 颜色分类_排序 {
    public static void main(String[] args) {
        /** 
            给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
            我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
            必须在不使用库的sort函数的情况下解决这个问题。
            输入：nums = [2,0,2,1,1,0]
            输出：[0,0,1,1,2,2]
        */

        int[] nums = new int[]{
            2,0,2,1,1,0
        };
        sortColors(nums);




    }
    public static void sortColors(int[] nums) {
        
        // int[] res =  bubbleSort(nums);
        // int[] res = selectionSort(nums);
        quickSort(nums, 0, nums.length);
        Arrays.stream(nums).forEach(item->{
            System.out.print(item);
        });


    }


    //冒泡排序， 向泡泡一样，从左往右往后冒,比较相邻的元素，如果第一个比第二个大，交换它们
    //第一轮需要比较n-1次，注意是比较，第二轮是n-2次(相当于n-1-i1)，第n-1比较1次
    //总的比较次数为(n-1) + (n-2) +... +1 约等于 n^2/2 ，复杂度就是O(n^2)
    public static int[] bubbleSort(int[] nums){

        int len = nums.length;
        //外层主要是为了提供i，让内层可以逐渐较少比较次数
        //内层控制的是比较的次数
        for(int i = 0 ; i < len-1; i++){
            //内层控制比较次数
            for(int j = 0; j < len-1-i ; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }

    //选择排序，选择小的值，往前放
    //选择排序就是重复“从待排序的数据中寻找最小值，将其于序列最左边的数字进行交换”
    //这一操作的算法，在序列中寻找最小值使用的是线性查找
    //so, 和冒泡排序同样的时间复杂度
    public static int[] selectionSort(int[] nums){
        int len = nums.length;
        int minIndex ; //用于标记最小值
        int temp; //缓存左侧值，用于后续交换
        //i实际上也限制总比较次数
        for(int i=0; i< len-1;i++){
            //初始化最小值下标为 左侧值下标
            minIndex = i;
            //寻找最小值索引，这里最后一个数也算上了，遍历后边所有
            for(int j=i+1; j< len ;j++){
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            //找好之后置换
            temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }
    
    
    //快速排序
    //分治法，理论形态是个树，每行为n，分成logn行，复杂度为nlogn
    public static void quickSort(int[] nums, int left,int right){

        if(left < right){
            int l,r,p;
            //初始化
            l = left;
            r = right;
            p = nums[l]; //基准
            
            while(l < r){
                //从右向左找第一个小于基准的值，没找到就继续减下标，找到之后跳出
                while(l < r && nums[r] >p) r--;
                if(l < r) nums[l++] = nums[r];
                //从左到右找到第一个大于基准的值
                while(l < r && nums[l] < p) l++;
                if(l < r) nums[r--] = nums[l];
            }
            nums[l] = p; //将基准值放在该放的位置
            //-1和+1是为了掠过基准
            quickSort(nums, left, l-1);
            quickSort(nums, l + 1, right);
        }
    }

    
}
