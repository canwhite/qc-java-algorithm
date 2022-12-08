package com.java.algorithm.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 对称二叉树 {
    public static void main(String[] args) {
        /**
         * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
         */
        
    }
    public static boolean isSymmetric(TreeNode root) {
        //判断是否二叉树
        if (root == null) {
            return true;
        }
        return cmp(root.left, root.right);
    }

    private static boolean cmp(TreeNode node1 ,TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null || node1.val != node2.val) return false;
        return cmp(node1.left, node2.right) && cmp(node1.right, node2.left);
    }

    //新的排序方法
    
    
    
    //如果我再写个方法
    //先转list再重新排序
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            //先将左侧遍历完
            if (cur != null) {
                //以当前例子来说，push 1，push5
                System.out.println("push"+cur.val);
                stack.push(cur); 
                cur = cur.left;//然后5的left是null
            } 
            //然后再看中间和右边
            else {
                cur = stack.pop(); //pop5
                System.out.println("pop" +cur.val);
                list.add(cur.val);//将5入栈
                cur = cur.right;//然后5的right也是null，下拨在pop1
            }
        }
        //返回列表
        return list;
    }


}
