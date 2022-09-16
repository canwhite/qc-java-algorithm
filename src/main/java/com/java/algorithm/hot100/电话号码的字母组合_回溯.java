package com.java.algorithm.hot100;

import java.util.ArrayList;
import java.util.List;

//给定一个仅包含数字 2-9 的字符串，
//返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
public class 电话号码的字母组合_回溯 {

    
    /** 
     * 回溯算法的一般流程是
     * for循环横向遍历，递归纵向遍历
     * 用于解决一些组合切割子集的问题
        void backtracking(参数) {
            if (终止条件) {
                存放结果;
                return;
            }

            for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
                处理节点;
                backtracking(路径，选择列表); // 递归
                回溯，撤销处理结果
            }
        }
     */


    //设置全局列表存储最后的结果
    static List<String> list = new ArrayList<>();
    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuild
    static StringBuilder temp = new StringBuilder();

    
    public static void main(String[] args) {
        
    }

    public static List<String> letterCombinations(String digits) {
        
        //这里选择横向和纵向时候是，
        //横向上一层数字对应的字符，纵向就是代表这一层字符的数字
        if(digits == null || digits.length() ==0){
            return list;
        }
        //为了直接对应2-9，新增两个无效字段
        String[] numStrings = {
            "","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        backtracking(digits, numStrings, 0);

        return null;
    }

    //比如digits如果为"23",num 为0，则str表示2对应的 abc
    //横向上一层数字对应的字符，纵向就是代表这一层字符的数字
    //回溯方法，
    //递归三要素：
    //--返回值：递归对应的返回值一般是void，因为通常是对一个全局数组进行操作
    //-------这里主要是对结果进行判断然后直接return
    //--参数是数字字符，映射字符串和对应的数字
    //--逻辑部分大多是处理，递归，回溯
    public static void backtracking(String digits,String[] numStrings,int num){
        //遍历全部一次，记录一次得到的字符串
        if(num == digits.length()){
            list.add(temp.toString());
            return; //跳出，然后走回溯步骤
        }
        //str表示当前num对应的字符串
        //为什么一个char Index要减去'0'变int
        //先确定每一层也就是for循环走啥？然后再看纵向是什么决定了到下一层，给到参数方便递归
        String str = numStrings[digits.charAt(num)-'0'];
        for(int i = 0; i< str.length();i++){
            //(1)操作
            temp.append(str.charAt(i));
            //(2)递归,往更深一层
            backtracking(digits, numStrings, num+1);

            //(3)回溯
            //剔除默认的继续尝试
            temp.deleteCharAt(temp.length() - 1);

        }
    }
}
