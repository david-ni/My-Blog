package com.myblog.algorithm.leetcode;

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 * @author David Wang <https://github.com/superTerrorist>
 */
public class N21MergeTwoSortedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 迭代法：
     * 1. 找出较小的链表作为迭代对象
     * 2. 每次与较大链表做对比
     * 时间复杂度: O(N) N为 min(N1,N2)次
     * 空间复杂度：O(1)
     **/
    public static ListNode solution1(ListNode list1, ListNode list2){
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode head;
        ListNode mergeList1 = head = list1.val > list2.val ? list2 : list1;
        ListNode mergeList2 = list1.val > list2.val ? list1 : list2;

        while (mergeList1.next != null && mergeList2 != null){
            if(mergeList1.next.val >= mergeList2.val){
                ListNode temp1 = mergeList1.next;
                ListNode temp2 = mergeList2.next;
                mergeList1.next = mergeList2;
                mergeList2.next = temp1;
                mergeList2 = temp2;
            }
            mergeList1 = mergeList1.next;
        }

        if(mergeList2 != null) mergeList1.next = mergeList2;

        return head;
    }

    public static void main(String[] args) {
        solution1(new ListNode(1,new ListNode(2, new ListNode(4, null))),
                new ListNode(1,new ListNode(3, new ListNode(4, null))));
    }
}
