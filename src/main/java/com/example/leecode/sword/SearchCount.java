package com.example.leecode.sword;

/**
 * @Author vansn
 * @Date 2022/2/18 上午9:03
 * @Version 1.0
 * @Description 统计出现次数
 */
public class SearchCount {

    public static void main(String[] args){
        int[] nums = {5,7,7,8,8,10};
        System.out.println(searchCount(nums, 8));
    }

    public static int searchCount(int[] nums,int target){

       return midCount(nums,0,nums.length-1,target);

    }

    public static int midCount(int[] nums,int left,int right,int target){
        if(nums[left]>target || nums[right] <target){
            return 0;
        }
        int count = 0;
        if(nums[left] == target){
            while (left <= right && nums[left] == target){
                count +=1;
                left++;
            }
            return count;
        }
        if(nums[right] == target){
            while (left <= right && nums[right] == target){
                count +=1;
                right--;
            }
            return count;
        }
        return midCount(nums,left,(left+right)/2,target) +
                midCount(nums,(left+right)/2+1,right,target);
    }
    //应该转换为去找边界   不应该用边界加
}
