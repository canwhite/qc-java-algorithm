package com.java.algorithm.hot100;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {

    private static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        
        List<String> list =  generateParenthesis(3);
        System.out.println(list.toString());

    }
    public  static List<String> generateParenthesis(int n) {
        //括号生成
        dfs(n,n,"");
        return res;
    }

    //dfs相对回溯算法来说少了回溯的步骤
    private static void dfs(int left,int right, String curStr){
        //左右括号都不剩余，递归终止
        if(left == 0 && right ==0){
            res.add(curStr);
            return;
        } 
        //每一层是left和right，深度是现有情况给到后新的拼接
        if(left > 0){
            dfs(left-1, right, curStr + "(");
        }
        //如果右括号多于左括号剩余的话，可以拼接右括号
        if(right > left){
            dfs(left, right-1, curStr + ")");
        }
    }
}
