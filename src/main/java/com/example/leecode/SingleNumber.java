package com.example.leecode;

/**
 * @Author vansn
 * @Date 2022/2/8 下午7:54
 * @Version 1.0
 * @Description
 */
public class SingleNumber {

public static void main(String[] args){
    int[] nums = {1,2,2,3,3,4,4};
    System.out.println(singleNumber(nums));
}
    public static int singleNumber(int[] nums){
        int single = 0;
        for(int x:nums){
            single =single ^x;
        }
        return single;
    }
}
