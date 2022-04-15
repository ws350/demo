package com.example.leecode;

import java.util.Vector;

/**
 * @Description
 * @Author: vansn
 * @Date: 2021/11/16 下午4:35
 */
public class RemoveDoumplicates {

    public static void main(String[] args) {
        int nums[] ={1,1,2,2,2,3,4,4,5,5,5,5,6};
        //1122344556
        int n = solution(nums);
        System.out.println("n = "+ n);
      //  System.out.println(nums.toString());
        for(int i:nums){
            System.out.println(i);
        }

    }

    public static int solution(int[] nums){
        int len = nums.length;
        if(len<2){
            return len;
        }
        int fast = 2,slow = 2;
        while(fast<len){

            if(nums[slow-2] != nums[fast]){
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;

        }
        return slow;

    }
}
