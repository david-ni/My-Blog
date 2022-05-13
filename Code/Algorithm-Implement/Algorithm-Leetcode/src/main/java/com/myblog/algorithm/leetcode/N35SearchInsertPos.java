package com.myblog.algorithm.leetcode;

/**
 * 搜索插入位置
 * https://leetcode.cn/problems/search-insert-position/
 * @author David Wang <https://github.com/superTerrorist>
 */
public class N35SearchInsertPos {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = nums[mid];
            if (value == target) {
                return mid;
            }
            if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
