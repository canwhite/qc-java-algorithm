package com.java.algorithm.hot100;

public class 合并两个有序链表 {
    public static void main(String[] args) {
        int[] arr = {1,3,5};
        int[] arr2 = {2,4,6,9};        
        Utils utils = new Utils();
        ListNode l1 = utils.arrayToListNode(arr);
        ListNode l2 = utils.arrayToListNode(arr2);
        utils.printListNode(mergeTwoLists(l1, l2));
    }
    //在一个动态方法里可以调用静态方法，因为静态方法相当于已经实例化过了
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //体会一下用空间换时间和用时间换空间的区别 ，类似于归并排序中的合并过程
        //这里先创建一个哑节点，作为拼接容器，这就是换取时间的空间
        ListNode dummyHead = new ListNode(0); 
        //初始将cur指向哑节点，然后就是比较和拼接
        ListNode cur = dummyHead;
        //开始拼接，考虑一个长度长，一个长度短的问题
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;  
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if(l1 == null){
            cur.next = l2;
        }else{
            cur.next = l1;
        }
        //返回哑节点的next
        return dummyHead.next;

    }   

}
