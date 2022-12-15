    package com.java.algorithm.hot100;

    import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
    import java.util.Stack;

    public class 对称二叉树 {
        public static void main(String[] args) {
            /**
             * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
             */ 
            TreeNode root = new TreeNode(1);
            root.right = new TreeNode(2);
            root.right.right = new TreeNode(3);
            root.left = new TreeNode(2);
            root.left.left = new TreeNode(3);

            //判断是否是对成二叉树
            boolean is = isSymmetric(root);
            System.out.println(is);


            
        }
        public static boolean isSymmetric(TreeNode root) {
            //判断是否二叉树
            if (root == null) {
                return true;
            }
            // return cmp(root.left, root.right);
            return cmp_new(root);
        }

        private static boolean cmp(TreeNode node1 ,TreeNode node2){
            if(node1 == null && node2 == null) return true;
            if(node1 == null || node2 == null || node1.val != node2.val) return false;
            return cmp(node1.left, node2.right) && cmp(node1.right, node2.left);
        }

        //新的排序方法
        private static boolean cmp_new(TreeNode node){

            List<Integer> list = inorderTraversal(node);
            //如何查看是左右对称的
            int len = list.size();
            //
            int mid = (int)(Math.floor(len/2));
            System.out.println(mid);
            System.out.println(list.toString());
            //使用subList进行拆分
            /** 
            //这里subList是左闭右开的
            List<T> first = new ArrayList<>(list.subList(0, (size + 1)/2));
            List<T> second = new ArrayList<>(list.subList((size + 1)/2, size));
            */
            List<Integer> pre = new ArrayList<>(list.subList(0, mid));
            System.out.println(pre.toString());

            //有右边不能达到
            List<Integer> next = new ArrayList<>(list.subList(mid+1, len));
            System.out.println(next.toString());
            
            //我们将后一个list倒叙，转成字符串和前一个比较  
            Collections.reverse(next);
            System.out.println(next.toString());

            return pre.toString().equals(next.toString());
        

        }

        

        //如果我再写个方法
        //先转list再重新排序
        public static List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;

            while (cur != null || !stack.isEmpty()) {
                //先将左侧遍历完
                if (cur != null) {
                    stack.push(cur); 
                    cur = cur.left;//然后5的left是null
                } 
                //然后再看中间和右边
                else {
                    cur = stack.pop(); //pop5
                    list.add(cur.val);//将5入栈
                    cur = cur.right;//然后5的right也是null，下拨在pop1
                }
            }
            //返回列表
            return list;
        }


    }
