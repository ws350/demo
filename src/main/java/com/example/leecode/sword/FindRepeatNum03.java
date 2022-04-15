package com.example.leecode.sword;

/**
 * @Author vansn
 * @Date 2022/2/18 上午8:49
 * @Version 1.0
 * @Description 查找重复数字
 */
public class FindRepeatNum03 {


    public static int findRepeatNum(int[] nums){
        for(int i = 0;i<nums.length;i++){
            //正确的位置，跳过
            if(i==nums[i]){
                continue;
            }
            //不在正确的位置，置换
            if(nums[i] == nums[nums[i]]){
                return nums[i];
            }else{
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }

        }
        return nums[0];
    }
}
