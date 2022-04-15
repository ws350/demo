package com.example.leecode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author xiaoma
 * @desc ...
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，
并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。
示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]

提示：
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案
 * @date 2021-10-11 15:29:07
 */
public class twoSum {

    public static void main(String[] args) {
        int[] n1 = new int[]{2,7,11,15};
        int n2 = 9;
        int[] res = twoSum2(n1,n2);
        for(int i:res){
            System.out.println(i);
        }

    }
    //暴力法
    public static int[] twoSum(int[] nums,int target){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for(int j=i+1;j<n;++j){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
            
        }
        return null;
    }
    //使用hashmap
    public static int[] twoSum2(int[] nums,int target){
        Map<Integer,Integer> hashtable = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(hashtable.containsKey(target - nums[i])){
                return new int[]{hashtable.get(target-nums[i]),i};
            }
            hashtable.put(nums[i],i);
            Stack<String> stack = new Stack<String>();
            stack.peek();
            stack.empty();
        }

        return new int[0];
    }

    public int[] twosum3(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            if(map.containsKey(target- nums[i])){
                return new int[]{map.get(target- nums[i]),i};
            }
            map.put(nums[i],i);
        }



        return  new int[0];
    }
}
