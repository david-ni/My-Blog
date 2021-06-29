package com.myblog.algorithm.leetcode;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 滑动窗口问题
 * @author David Wang <https://github.com/superTerrorist>
 */
public class LengthOfLongestSubstring{
    /**
     * 暴力解法
     * 暴力解法的问题：
     * 1. java string的不变性导致每次都会生成新的字符串，内存占用高
     * 2. indexOf 本质也是从头到尾的循环查找 效率并不高
     */
    public int run(String s){
        String str = "";
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int index = str.indexOf(String.valueOf(c));
            if(index != -1){
                maxLength = Math.max(maxLength,str.length());
                str = index >= str.length() - 1 ? "" : str.substring(index + 1);
            }
            str += c;
        }
        return Math.max(str.length(),maxLength);
    }
}
