package com.myblog.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David Wang <https://github.com/superTerrorist>
 */
public class N234PalindromeLink {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 解法1：
     * 1. 将链表拷贝到数组
     * 2. 对比数组收尾元素是否相等
     * 时间复杂度：O(N)
     */
    public static boolean solution1(ListNode head) {
        if(head == null) return false;

        List<Integer> array = new ArrayList<>();
        ListNode node = head;

        while (node != null){ // 拷贝到数组
            array.add(node.val);
            node = node.next;
        }

        int size = array.size();

        for(int i = 0; i < size/2; i++){
            if(array.get(i) != array.get(size - i - 1)) return false;
        }

        return true;
    }

    /**
     * 解法2：
     * 1. 反转链表（需拷贝）
     * 2. 一一对比新链表与原链表 如果是回文的话 每个元素应该都是相同的
     */
    public static boolean solution2(ListNode head){
        return false;
    }

    /**
     * 解法3
     * 1. 快慢指针找出中间点
     * 2. 反转后半段链表（前半段链表好像跟快）
     * 3. 对比
     */
    public static boolean solution3(ListNode head){
        return false;
    }


    public static void main(String[] args) {
        solution1(new ListNode(1));
    }
}
