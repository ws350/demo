package com.example.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author vansn
 * @Date 2022/2/9 下午3:29
 * @Version 1.0
 * @Description 多数元素：一个数组里头超过半数的元素
 */
public class MajorityElement {

    public static void main(String[] args){
        int[] nums = {3,2,3};
        System.out.println(majorityElemetHash(nums));
        System.out.println(majorityElementVote(nums));
    }

    //使用hash数组实现
    public static int majorityElemetHash(int[] nums){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        Map.Entry<Integer,Integer> majoEntry = null;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(majoEntry == null || majoEntry.getValue() < entry.getValue()) {
                majoEntry = entry;
            }
        }
        return majoEntry.getKey();
    }

    //投票法
    //即相当于守擂台，守到最后还有的为超过半数的
    public static int majorityElementVote(int[] nums){
        int cur = 0,val = 0;
        for(int x:nums){
            if(val == 0 ){
                cur = x;
            }
            val += (cur==x)?1:-1;
        }
        return cur;
    }

}
