package com.java.algorithm.hot100;


public class 两数相加 {
    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        
        ListNode node = addTwoNumbers(l1, l2);
        System.out.print(node.val);
        
    }

    /** 
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
        请你将两个数相加，并以相同形式返回一个表示和的链表。
     */
    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode root = new ListNode(0);
        ListNode cursor = root;//创建游标
        int carry = 0; //carry相当于进位之后的值
        while(l1!=null || l2!=null || carry!=0){
            int l1Val = l1 !=null ? l1.val :0;
            int l2Val = l2 !=null ? l2.val :0;
            //拿到总值,如果上一次有进位，这里加上
            int sumVal = l1Val + l2Val + carry;
            //拿到进位
            carry = sumVal/10;

            //封装一下当前位
            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            //l1和l2也继续往下走
            if(l1 != null)  l1 = l1.next; 
            if(l2 != null)  l2 = l2.next;
        }
        return root.next; 
    }



    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int  val){ this.val = val;}
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    
}
