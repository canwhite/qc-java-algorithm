package com.java.algorithm.hot100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的最大深度 {

    static List<List<Integer>> resList = new ArrayList<>();

    public static void main(String[] args) {
        //进一步去想这个代码如何写好是一个好的方向
    }
    public static int maxDepth(TreeNode root) {



        return 0;
    }


    //基于bfs的层级测算。以1-2-3的实例去理解
    public static void BFS(TreeNode node){
        //以上一part对BFS的理解，我们在这里尝试写一一下bfs
        
        if(node ==null) return ;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(node);//从尖尖开始
    

        while(!queue.isEmpty()){
            //阶段结果集
            List<Integer> itemList = new ArrayList<>();
            //拿到上一层长度
            int len = queue.size();

            //将上一层的数据封装，顺便push下一层的数据 
            while(len >0){
                //先创建一个
                TreeNode tmp = queue.poll();
                itemList.add(tmp.val);
                if(tmp.left !=null) queue.offer(tmp.left);
                if(tmp.right != null) queue.offer(tmp.right);
                len --;
            }

            resList.add(itemList);

        }

    }



    //基于dfs的层级测算
    public static void DFS(TreeNode root){

    }




    
}
