package com.java.algorithm.hot100;

import java.util.Arrays;

public class 后续和中序遍历构造二叉树 {
    public static void main(String[] args) {
        
        int[] postorder = new int[]{
            9,15,7,20,3
        };
        int[] inorder = new int[]{
            9,3,15,20,7
        };
        TreeNode tree = buildTree(postorder, inorder);
        System.out.println(tree.left.val);
        System.out.println(tree.right.val);
        System.out.println(tree.right.left.val);
        System.out.println(tree.right.right.val);
        
    }
    //后续和中序
    public static TreeNode buildTree(int[] postorder, int[] inorder) {
        //先写终止条件
        if(postorder.length == 0 || inorder.length ==0) return  null;
        //根节点从postorder最后一个拿
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        for(int i = 0; i < inorder.length; i++){

            //中序的值和post尾巴相等的时候，
            //注意边界数据，其他的根据inOrderLeft取就可以了
            if(postorder[postorder.length-1] == inorder[i]){
                //中序还是很好整的
                int[] inOrderLeft = Arrays.copyOfRange(inorder,0,i);
                int[] inOrderRight = Arrays.copyOfRange(inorder,i+1 , inorder.length);
            
                //后续稍微麻烦点，是基于中序的
                int[] postOrderLeft = Arrays.copyOfRange(inorder, 0, 0+inOrderLeft.length);
                //需要特别注意的是右边界
                int[] postOrderRight = Arrays.copyOfRange(postorder, 0 + inOrderLeft.length, postorder.length-1);

                root.left = buildTree(postOrderLeft, inOrderLeft);
                root.right = buildTree(postOrderRight, inOrderRight);
                break;
            }
        }
        return root;
    }



}
