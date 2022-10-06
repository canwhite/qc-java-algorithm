package com.java.algorithm.hot100;

import java.util.ArrayList;
import java.util.List;

public class 组合总和 {
    //全局创建了一些参数
    static List<Integer> list = new ArrayList<>();
    static List<List<Integer>> ans = new ArrayList<>();
    static int target;
    static int len;

    public static void main(String[] args) {
        /**
         * 
         * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
         * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
         * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
         * 
         * candidates 中的 同一个 数字可以 无限制重复被选取 。
         * 如果至少一个数字的被选数量不同，则两种组合是不同的。 
         * 
         * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
         */


         /* 
          * ps : 一个示例
          * 输入: candidates = [2,3,5], target = 8
          * 输出: [[2,2,2,2],[2,3,3],[3,5]]
          */


          /**
           * 求子集的问题我首先想到的就是回溯
           * 看到一种说法是dfs是最典型的回溯算法的结构，之前的写法是没有pop，保留了所有值
           * 有时间可以再看看，我可以理解回溯本身就是为了遍历各种可能性导出可能性
           * 
           */
        //todo 做完这个我们再拿一个dfs分析一下
        //这里是求一个一维数组的各种组合
        int[] candidates = new int[]{2,3,5};
        int target = 8;
        combinationSum(candidates, target);


        ans.stream().forEach(item->{
            //将内部数组转化为字符串
            System.out.println(item.toString());
        });
        
    }
    
    
    public static List<List<Integer>> combinationSum(int[] candidates, int tg) {
        target = tg;
        len = candidates.length;
        backward(0, candidates, 0);
        return ans;
    }

    //典型回溯
    //实际上回溯真正需要的参数也就是这三个，
    //一个结果判断标识，一个循环数组，一个循环位置
    public static void backward(int sum,int[] candidates ,int index) {
        //首先退出机制，这里安排了一个sum参数，让这个求和的过程能够延续
        if(sum > target) return;
        if(sum == target){
            //这里封装我们的结果集合，然后再返回
            //从一个list初始化一个list
            //结果集合、target和
            /** new ArrayList可以接收两种参数
             * 一个是数量，可以先确定大小
             * 一个是Collection，可以根据集合顺序新建list
             * 再进一步思考一下，Array好像也是这样，针对第二项，int[]{字面量},区别于参数传入
             */
            ans.add(new ArrayList<>(list));
            return;
        }

        //做一些剪枝的操作
        if(candidates[index] > target){
            return;
        }

        //然后是回溯主体
        for(int i = index;i< len;i++){
            //关注组合item
            list.add(candidates[i]);
            backward(sum+candidates[i], candidates, i);
            //如果一个深度挖完了，我们需要清理一下list，然后再重新计算
            //这里的remove是根据index删除的
            list.remove(list.size() -1);
        }
    }
}


