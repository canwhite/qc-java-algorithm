package com.java.algorithm.hot100;

import java.util.Stack;

public class 有效的括号 {
    public static void main(String[] args) {
        String s = "()"; 
        System.out.println(isValid(s)); 
    }
    public  static boolean isValid(String s) {
        //建立一个新的栈，然后遍历字符串的字符，进行比较
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            //一共有三种情况
            //(1)左侧冗余
            //(2)中间括号不匹配
            //(3)右侧冗余
            if(c=='(')stack.push(')');
            else if(c=='[')stack.push(']');
            else if(c=='{')stack.push('}');
            //后边的括号应该和前边是一一对应的，
            //如果循环进行完之前已经pop完了，说明后边的括号比前边的多，gg
            //如果到后边开始pop的时候，和前边按顺序的不匹配，说明情况二，括号不匹配
            else if(stack.isEmpty() || c!=stack.pop()) return false;
        }
        //如果循环完正好为空，说明是一一对应的，完美
        return stack.isEmpty();
    }
}
