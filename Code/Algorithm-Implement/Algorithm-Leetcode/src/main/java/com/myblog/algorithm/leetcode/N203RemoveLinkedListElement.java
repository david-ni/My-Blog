package com.myblog.algorithm.leetcode;

/**
 * Remove Linked List Elements
 * https://leetcode.cn/problems/remove-linked-list-elements/
 * @author David Wang <https://github.com/superTerrorist>
 */
public class N203RemoveLinkedListElement {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 解法一
     * 从头遍历到尾
     * 时间复杂度：O(N) N为链表的长度
     */
    public ListNode solution1(ListNode head, int val) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            if(cur.val == val){
                if(prev == null){
                    head = cur.next;
                }else{
                    prev.next = cur.next;
                }
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
