package com.example.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author vansn
 * @Date 2022/4/9 上午9:42
 * @Version 1.0
 * @Description  三数之和
 * 给你一个包含 n 个整数的数组nums，nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。

 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        //从第一个数字开始遍历
        for(int first = 0;first <n;++first){
            //不能有重复的数据
            if(first >0 && nums[first] == nums[first-1]){
                continue;
            }

            //c指向数组的最右端
            int third =n-1;
            int target = -nums[first];

            for(int second = first +1;second<n ;++second){
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                //保证b指针在c左侧
                while (second < third && nums[second] + nums[third] > target){
                    --third;
                }
                if(second == third){
                    break;
                }

                if(nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }



            }



        }
        return ans;


    }
}
