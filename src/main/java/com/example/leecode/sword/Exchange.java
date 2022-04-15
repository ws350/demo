package com.example.leecode.sword;

/**
 * @Author vansn
 * @Date 2022/3/6 下午8:32
 * @Version 1.0
 * @Description  数组的奇数在前，偶数在后
 */
public class Exchange {

    public static void main(String[] args){
        int[] nums = new int[]{1,3,5};
        exchange(nums);
    }

    public static int[] exchange(int[] nums) {
        if(nums.length <2) return nums;
        int pA = 0,pB = nums.length-1;
        while(pA <= pB){
            //偶数
            if(nums[pA]%2 == 0){
                int temp = nums[pA];
                nums[pA] = nums[pB];
                nums[pB] = temp;
                pB--;
            }else{
                pA++;
            }
            //右边是奇数
            if(nums[pB] % 2 == 1){
                int temp = nums[pB];
                nums[pB] = nums[pA];
                nums[pA] = temp;
                pA ++;
            }else{
                pB--;
            }
        }
        return nums;
    }
}
