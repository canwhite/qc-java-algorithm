package com.java.algorithm.hot100;
import java.util.Arrays;

public class 前序和中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        /**
         * 给定两个整数数组 preorder 和 inorder ，
         * 其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
         * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
         * 输出: [3,9,20,null,null,15,7]
         */


         /**
          * 思路：
          * preorder第一个元素为root，在inorder里面找到root，在它之前的为左子树（长l1），之后为右子树（长l2）。
          * preorder[1]到preorder[l1]为左子树,之后为右子树，分别递归。 
          *
          */
        int[] preorder = new int[]{
            3,9,20,15,7
        };
        int[] inorder = new int[]{
            9,3,15,20,7
        };
        TreeNode tree =  buildTree(preorder, inorder);
        // System.out.println(tree.left.val);
        System.out.println(tree.left.val);
        System.out.println(tree.right.val);
        System.out.println(tree.right.left.val);
        System.out.println(tree.right.right.val);


        /** 注意copyOfRange取值是左闭右开的 */
        /** 
        int[] a = new int[]{1,2,3,4,5};
        int[] b = Arrays.copyOfRange(a, 0, 2);
        System.out.println(Arrays.toString(b));
        */
        
        


    }


    //PS：copyOfRange是Arrays截取数组的方法
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length ==0 || inorder.length ==0) return null;
        //从preorder拿到根节点
        TreeNode root = new TreeNode(preorder[0]);
        //然后两边分别开始递归
        for(int i = 0 ; i< inorder.length ; i++){
            //在满足条件的时候递归就可以了，其他状态不用判断
            //第一次满足条件的时候i == 1；
            //主要这个i事inorder的中间
            if(preorder[0] == inorder[i]){

                //这里边中序的很好理解
                //考虑一个问题，pre除了root放前，然后左右，排除index = 0；截取的长度和inorder是一致的，只是位置往后挪动了一位而已
                int[] inOrderLeft = Arrays.copyOfRange(inorder,0,i);
                
                //分割点去掉，起始位置，加上中左的长度，length相对下标来说，是取不到最后一个值的，
                //另外终点值都是依靠
                int[] preOrderLeft = Arrays.copyOfRange(preorder, 1, 1 + inOrderLeft.length);
                root.left = buildTree(preOrderLeft,inOrderLeft);


                
                //右边的计算
                int[] inOrderRight = Arrays.copyOfRange(inorder,i+1 , inorder.length);
                //然后剩下的部分,需要确定起始位置,然后起始位置的基础上加上右边长度
                int[] preOrderRight = Arrays.copyOfRange(preorder,1 + inOrderLeft.length, 1 + inOrderLeft.length + inOrderRight.length);
                
                root.right=buildTree(preOrderRight,inOrderRight);
                break;
            }
        }
        //最后返回头部就可以了 
        return root;
    }
    
}
