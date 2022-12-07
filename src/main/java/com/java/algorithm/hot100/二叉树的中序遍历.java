    package com.java.algorithm.hot100;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

    public class 二叉树的中序遍历 {
        
        public static void main(String[] args) {
            //这里前中后是根的位置
            //前序(根左右)，中序(左根右)，后序(左右根)


            /**********************************************
                # 思路：基于栈的中序遍历
                # 中序遍历 先遍历左子树->根节点->右子树
                # 如果是递归做法则递归遍历左子树，访问根节点，递归遍历右子树
                # 非递归过程即:先访问..最左子树..结点，再访问其父节点，再访问其兄弟
                # while循环条件 中序遍历需先判断当前结点是否存在，若存在则将该节点放入栈中，再将当前结点设置为结点的左孩子，
                # 若不存在则取栈顶元素为cur，当且仅当栈空cur也为空，循环结束。
            ************************************************/   
            //先搞一个验证吧
            TreeNode root = new TreeNode(1);
            root.right = new TreeNode(2);
            root.right.left = new TreeNode(3);
            root.right.left.right = new TreeNode(4);

            List<Integer> list =  inorderTraversal(root);
            list.stream().forEach(item->{
                System.out.println(item);
            });

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
                    cur = cur.right;
                }
            }
            //返回列表
            return list;
        }

    }
