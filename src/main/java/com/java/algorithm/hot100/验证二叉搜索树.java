package com.java.algorithm.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 验证二叉搜索树 {
    //相当于设置一个负无穷值
    static double last = -Double.MAX_VALUE;
    public static void main(String[] args) {


        /**给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
        * 有效的二叉搜索树定义如下：
        * 节点的左子树只包含 小于 当前节点的数。
        * 节点的右子树只包含 大于 当前节点的数。
        * 所有左子树和右子树自身必须也是二叉搜索树。
        *   输入：root = [2,1,3]
        *   输出：true
        * 思路：
        * 中序遍历为升序，即为二叉搜索树 
        * 这里用递归和单调栈两种方式来处理 
        */
        
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);

        //boolean res = isValidBST_recursion(root);
        boolean res = isValidBST_stack(root);
        System.out.println(res);

    }

    public static boolean isValidBST_recursion(TreeNode root) {
        if(root == null){
            return true;
        }else{
            //先判断root.left
            if(!isValidBST_recursion(root.left)) return false;
            if(last >= root.val) return false; 
            last = root.val;
            if(!isValidBST_recursion(root.right)) return false;
            return  true;
        }
    }

    //stack
    public static boolean isValidBST_stack(TreeNode root){

        List<Integer> list =  inorderTraversal(root);
        //boolean is = true;    
        System.out.println(list.toString()); 
        for(int i = 0; i< list.size();i++){
            if(list.get(i) < last) return false;
            //主要在于比较
            last = list.get(i);
        }
        return true;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            //先将左侧遍历完
            if (cur != null) {
                stack.push(cur); 
                cur = cur.left;
            } 
            //然后再看中间和右边
            else {
                cur = stack.pop(); 
                list.add(cur.val);
                cur = cur.right;//然后5的right也是null，下拨在pop1
            }
        }
        //返回列表
        return list;
    }
}
