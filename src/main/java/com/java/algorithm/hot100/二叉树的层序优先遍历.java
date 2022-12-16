package com.java.algorithm.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层序优先遍历 {
    public static void main(String[] args) {
        //这个先想起来的的办法就是递归，BFS广度优先查询
        /**
         * 题目：
         * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 
         *（即逐层地，从左到右访问所有节点）。
         * 输入：root = [3,9,20,null,null,15,7]
         * 输出：[[3],[9,20],[15,7]]
         */
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);  

        List<List<Integer>>  list = levelOrder(root);
        System.out.println(list.toString());



        
    }
    public static List<List<Integer>> resList = new ArrayList<List<Integer>>();
    
    public static  List<List<Integer>> levelOrder(TreeNode root) {
        //BFS--迭代方式--借助队列
        checkFun02(root);
        return resList;
    }

    //BFS-借助队列
    public static void checkFun02(TreeNode node) {
        if(node == null) return;
        //队列实现的实例，用的是链表
        Queue<TreeNode> que = new LinkedList<>(); 
        //先将当前node添加上去
        que.offer(node);
        while(!que.isEmpty()){
            List<Integer> itemList = new ArrayList<>();
            int len = que.size();
            while(len > 0){
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
                len--;

            }
            resList.add(itemList);
        }

    }
}