package com.example.leecode;

import org.elasticsearch.search.aggregations.metrics.Max;

/**
 * @Author vansn
 * @Date 2022/1/26 上午11:39
 * @Version 1.0
 * @Description
 */
public class MaxSubArray {

    public static void main(String[] args){
        int[] nums = {-2,1};
        System.out.println(subArray3(nums));
    }

    //官方解法
    public int maxSubArray(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int maxVal = nums[0],pre=0;
        for(int x:nums){
            pre = Math.max(pre+x,x);
            maxVal = Math.max(maxVal,pre);
        }
        return maxVal;
    }

    //自己写法
    public static int subArray3(int[] nums){
        int pre = 0,maxAns = nums[0];
        for(int i = 0;i<nums.length-1;i++){
            pre = Math.max(pre+nums[i],nums[i]);
            maxAns = Math.max(maxAns,pre);
        }
        return maxAns;
    }




    //动态规划解法
    public int maxSubArraryDp(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for(int i=1;i<len;i++){
            if(dp[i-1] >0){
                dp[i] = dp[i-1] +nums[i];
            }else{
                dp[i] = nums[i];
            }
        }
        int res = dp[0];
        for(int i=1;i<len;i++){
            res = Math.max(res,dp[i]);
        }
        return res;

    }
}
