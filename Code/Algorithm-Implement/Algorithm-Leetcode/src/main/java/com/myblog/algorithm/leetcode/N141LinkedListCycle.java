package com.myblog.algorithm.leetcode;

/**
 * 链表是否有环
 * https://leetcode.cn/problems/linked-list-cycle/
 * @author David Wang <https://github.com/superTerrorist>
 */
public class N141LinkedListCycle {
     class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
     }


     public boolean hasCycle(ListNode head) {
         // 快慢指针
         ListNode lower = head;
         ListNode faster = head;
         while(faster != null && faster.next != null){
             //慢指针每次走一步
            lower = lower.next;
             //快指针每次走两步
            faster = faster.next.next;
             //如果相遇，说明有环，直接返回true
            if(lower == faster) return true;
         }
         return false;
     }
}
