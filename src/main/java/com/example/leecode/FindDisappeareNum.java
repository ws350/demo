package com.example.leecode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author vansn
 * @Date 2022/2/12 下午9:47
 * @Version 1.0
 * @Description 寻找消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n]
 * 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 */
public class FindDisappeareNum {

    public static void main(String[] args){
      int[] nums = {4,3,2,7,8,2,3,1};
      List<Integer> list = find(nums);
      for(int x:list){
          System.out.print(x + " ");
      }
    }

    public static List<Integer> find(int[] nums){
        int len = nums.length;
        for(int x:nums){
            int index = (x-1)%len;
            nums[index] = nums[index] +len;
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ;i < len ;i++){
            if(nums[i] <= len){
                list.add(i+1);
            }
        }
        return list;
    }
}
