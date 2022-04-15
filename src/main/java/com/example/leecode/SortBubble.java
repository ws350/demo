package com.example.leecode;

/**
 * @Author vansn
 * @Date 2022/2/9 上午8:51
 * @Version 1.0
 * @Description  冒泡排序
 */
public class SortBubble {

    public static void main(String[] args){
      int[] nums = {1,3,2,5,8,6,3,5};
       nums = sortBubble(nums);
       for(int x:nums){
           System.out.println(x + " ");
       }
    }


    public static int[] sortBubble(int[] nums){
        if(nums == null || nums.length <2){
            return nums;
        }
        int temp = 0;
        for(int i = nums.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(nums[j]>nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }

            }
        }
        return nums;

    }

}
