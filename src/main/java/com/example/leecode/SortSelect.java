package com.example.leecode;

/**
 * @Author vansn
 * @Date 2022/2/9 上午9:11
 * @Version 1.0
 * @Description 选择排序
 */
public class SortSelect {

    public static void main(String[] args){
        int[] nums = {1,4,2,1,3,4,7,5,6,9,3,0};
        nums = sortSelect(nums);
        for(int x:nums){
            System.out.print(x+" ");
        }
    }

    public static int[] sortSelect(int[] nums){
        if(nums == null|| nums.length <2){
            return nums;
        }
        int minVal = 0;
        for(int i = 0;i<=nums.length -1;i++){

            for(int j=i;j<=nums.length-1;j++){
                if(nums[i] > nums[j]){
                    minVal = nums[i];
                    nums[i] = nums[j];
                    nums[j] = minVal;
                }
            }

        }
        return nums;
    }
}
