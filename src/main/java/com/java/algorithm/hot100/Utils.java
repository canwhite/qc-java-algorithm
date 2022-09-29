package com.java.algorithm.hot100;

import java.util.ArrayList;
import java.util.List;

public class Utils {


    public static void main(String[] args) {
        
        //这个main和python的main差不多，我们可以在内部实例化验证自身
        Utils util = new Utils();

        //先搞一个listNode
        ListNode dumpyNode = new ListNode(0);
        //在找一个cur来拓展dumpyNode，最后到处dumpyNode
        ListNode cur = dumpyNode;
    

        for(int i =1; i< 4;i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        util.printListNode(dumpyNode.next);
        //将array转化为listNode
        //最后得到的是一个

        Integer[] arr =  util.listNodeToArray(dumpyNode.next);
        for (Integer integer : arr) {
            System.out.println("--"+integer);
        }
    

    }


    /** 将数组转化为链表 */
    public ListNode arrayToListNode(int[] s){
        ListNode root = new ListNode(s[0]);//生成链表的根节点，并将数组的第一个元素的值赋给链表的根节点
        ListNode other = root;//生成另一个节点，并让other指向root节点，other在此作为一个临时变量，相当于指针
        for (int i = 1; i < s.length; i++) {//由于已给root赋值，所以i从1开始
            //节点拼接的话，需要一个实例节点作为next
            ListNode temp = new ListNode(s[i]);//每循环一次生成一个新的节点,并给当前节点赋值
            other.next = temp;//将other的下一个节点指向生成的新的节点
            other = temp;//将other指向最后一个节点(other的下一个节点)  other=other.getNext();
        }
        return root;
    }


    //将链表转化为数组
    public  Integer[] listNodeToArray(ListNode listNode){
        //一个数组
        List<Integer> list = new ArrayList<>();
        while(listNode != null){
            list.add(listNode.val);
            //注意，链表也需要往下走，把while看作for，它也是需要i++的】
            listNode = listNode.next;
        }
        // toArray
        // (1)toArray如果不加参数转化出来的是Object[],
        // (2)注意基本类型是不能作为泛型参数的。如果是使用int[] 类型数组，需要把 int[] 换成 Integer[] 。

        Integer[] array =  list.toArray(new Integer[list.size()]); 

        return array;
    }

    /** 遍历一个链表 */
    public  void  printListNode(ListNode l){
        while(l != null){
            System.out.println(l.val);
            l = l.next;
        }
    }
    
}
