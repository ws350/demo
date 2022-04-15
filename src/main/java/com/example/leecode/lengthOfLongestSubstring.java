package com.example.leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiaoma
 * @desc ...给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
 *
 *
 * @date 2021-10-11 17:11:35
 */
public class lengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubString1(s));
    }

    public static int lengthOfLongestSubString1(String s){
        //hashset 不能有重复值，记录每个字符是否重复出现
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        int rk=-1,ans=0;
        for (int i = 0; i < n; i++) {
            //滑动窗口，每滑动一次就移除一个
             if(i!=0){
                 occ.remove(s.charAt(i-1));
             }
             while(rk+1<n && !occ.contains(s.charAt(rk+1))){
                 occ.add(s.charAt(rk+1));
                 ++rk;
             }
            ans=Math.max(ans,rk-i+1);

        }
        return ans;


    }
}
