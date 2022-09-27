package com.java.algorithm.hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 合并k个升序链表 {
    public static void main(String[] args) {
        //先创建三个链表，然后将三个链表转化为数组，传进去，输出结果


        
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        
        //优先队列默认给到的是小顶堆
        //remove和poll获取并删除队首元素
        //直接用最小堆优先队列做的排序  

        if(lists.length == 0){
            return null;
        }

        //创建一个哑节点，最后用来合成新链表
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        //创建一个最小堆优先队列
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            //在这里是用一个接口类做的参数
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;//返回小的值
            }
        });

        //然后将list放入pq
        for(ListNode list : lists){
            //todo
            if(list == null){
                continue;
            }
            pq.add(list);
        }
        //然后用poll删除着合并着新链表
        while(!pq.isEmpty()){
            //删除的到，然后再往里并
            ListNode nextNode = pq.poll();
            curr.next = nextNode;
            //然后将curr往后挪一位
            curr = curr.next;
            //如果这条链没走完，我们就把后边的数据还放在pq
            //中继续往下走
            if(nextNode.next != null) {
                pq.add(nextNode.next);
            }
        }

        //如果最后添加完了，就返回新组成的链表
        return dummyHead.next;

    }
}
