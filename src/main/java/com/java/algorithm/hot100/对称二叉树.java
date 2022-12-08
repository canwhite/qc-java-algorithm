package com.java.algorithm.hot100;


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

}
