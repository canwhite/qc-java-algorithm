package com.java.algorithm.hot100;

/** 
 * 通用listNode节点，其他部分都用这个
 */
public  class ListNode{
    int val;
    ListNode next; //所谓next也是一个ListNode
    ListNode(){};
    ListNode(int  val){ this.val = val;}
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}