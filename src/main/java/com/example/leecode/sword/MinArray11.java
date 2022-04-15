package com.example.leecode.sword;

/**
 * @Author vansn
 * @Date 2022/2/19 上午11:44
 * @Version 1.0
 * @Description  旋转数组最小数字
 * 给你一个可能存在重复元素值的数组numbers，
 * 它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
 * 请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，
 * 该数组的最小值为1。
 **/

public class MinArray11 {


    public static int minArray(int[] numbers){
        if(numbers == null ){
            return 0;
        }
        if(numbers.length ==1){
            return numbers[0];
        }
        for(int i = 1;i<numbers.length;i++){
            if(numbers[i] <numbers[i-1]){
                return numbers[i];
            }
        }
        return numbers[0];
    }



    //二分法
    public static int findMin(int[] nums){

return 0;

    }



}
