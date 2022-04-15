package com.example.leecode;

/**
 * @Author vansn
 * @Date 2022/2/10 上午10:09
 * @Version 1.0
 * @Description 归并排序
 */
public class SortMerge {

    public static int[] sortMerge(int[] nums){
        int[] temp = new int[nums.length];
        sort(nums,0,nums.length-1,temp);
        return  nums;
    }

    public static void sort(int[] nums,int left,int right,int[] temp){
        if(left<right){
            int mid = left + right/2;
            sort(nums,left,mid,temp);
            sort(nums,mid+1,right,temp);
            merge(nums,left,mid,right,temp);
        }
    }

    public static void merge(int[] nums,int left,int mid,int right,int[] temp){
        int i = left;//左边指针
        int j = mid+1;//右边指针
        int t = 0;

        while(i<= mid && j <=right){
            if(nums[i] < nums[j]){
                temp[t++] = nums[i++];
            }else{
                temp[t++] = nums[j++];
            }
        }
        //处理越界
        while(i<=mid){
            temp[t++] = nums[i++];
        }
        while(j<=right){
            temp[t++] = nums[j++];
        }
        t=0;
        while(left<right){
            nums[left++] = temp[t++];
        }

    }
}
