package com.myblog.algorithm.leetcode;

/**
 * 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * @author David Wang <https://github.com/superTerrorist>
 */
public class N160IntersectionLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
