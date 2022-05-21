package com.myblog.algorithm.leetcode;

import java.util.List;

/**
 * Remove Nth Node From End of List
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * @author David Wang <https://github.com/superTerrorist>
 */
public class N19RemoveNthNodeEndOfList {
     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     /**
      * 基本思路：
      * 双指针 A and B
      * 1. B指针不动 A指针向前走n步, 即A、B间隔n
      * 2. A、B同时向前移动，直到末尾
      * 时间复杂度：
      * O(M) M表示链表的长度
      */
     public ListNode removeNthFromEnd(ListNode head, int n) {
         if(head == null) return head;
         int step = n;
         ListNode nA = head;
         ListNode nB = head;
         while (nA.next != null){
             nA = nA.next;
             if(step == 0){
                 nB = nB.next;
             }else{
                 step--;
             }
         }
         if(step != 0) return head.next;
         nB.next = nB.next.next;
         return head;
     }
}
