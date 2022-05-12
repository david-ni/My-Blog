package com.myblog.algorithm.leetcode;

/**
 * 二分查找
 * https://leetcode.cn/problems/binary-search/
 * @author David Wang <https://github.com/superTerrorist>
 */
public class N704BinarySearch {
    public static int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int minIndex = -1;
        do{
            minIndex = startIndex + (endIndex - startIndex)/2;
            if(target > nums[minIndex]){
                startIndex = minIndex;
            }else{
                endIndex = minIndex;
            }
            if(nums[startIndex] == target) return startIndex;
            if(nums[endIndex] == target) return endIndex;
        }while (startIndex != (endIndex - 1) && startIndex != endIndex);
        return -1;
    }
}
