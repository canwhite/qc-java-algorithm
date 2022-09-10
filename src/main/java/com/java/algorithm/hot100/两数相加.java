package com.java.algorithm.hot100;

public class 两数相加 {
    public static void main(String[] args) {
        


    }

    /** 
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
        请你将两个数相加，并以相同形式返回一个表示和的链表。
     */



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
