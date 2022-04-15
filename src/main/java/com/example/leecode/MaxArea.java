package com.example.leecode;

/**
 * @Author vansn
 * @Date 2022/4/8 下午5:34
 * @Version 1.0
 * @Description
 *
 *   盛水最多的容器
 */
public class MaxArea {

    public int maxArea(int[] nums){
        if(nums == null  || nums.length <2) return 0;
        int i=0,j=nums.length-1,maxVal = 0,cur = 0;

        while(i<=j){
           cur = Math.min(nums[i],nums[j])*(j-i);
           if(cur > maxVal) maxVal = cur;
           if(nums[i]<nums[j]){
               i++;
           }else{
               j--;
           }

        }
        return maxVal;
    }


}
