package com.java.algorithm.hot100;

/* 注意是倒数删除 */
public class 删除链表的倒数第n个节点 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        
        Utils utils = new Utils();

        ListNode l = utils.arrayToListNode(arr);
        utils.printListNode(l);
        
        System.out.println("------------------");

        ListNode r = removeNthFromEnd(l,2);
        System.out.println("------------------");
        utils.printListNode(r);
        
    }




    
    /** 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 */
    //注意是倒数的链表
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        //有一个哑节点的概念
        ListNode pre=new ListNode(0,head);
        //快慢指针
        ListNode fast=pre;
        ListNode slow=pre;

        // fast先走n+1步，然后同时走，确保slow.next是要删除的元素。
        for (int i = 0; i < n +1; i++) {
            //找到next的位置
            fast=fast.next;
        }
    
        //fast和slow是同一个指针，
        while (fast.next!=null){
            //从正确位置往后走，走到有值的地方，相当于当前位没走
            fast=fast.next;     
            slow=slow.next;
        }
        //再next就是对应位
        slow.next=slow.next.next;
        return pre.next;
    }   

}



