package com.example.leecode.sword;

/**
 * @Author vansn
 * @Date 2022/2/19 上午9:55
 * @Version 1.0
 * @Description 二维有序数组查找
 */
public class FindNumberIn2DArrary04 {


    public static void main(String[] args){
        int[][] nums = new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};
        fineBinary(nums,5);
    }

    //暴力
    public static boolean find(int[][] nums,int target){
        if(nums == null || nums.length == 0 || nums[0].length==0){
            return false;
        }
        int row = nums.length,col = nums[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(nums[i][j]==target){
                    return true;
                }
            }
        }
        return false;

    }




    public static boolean fineBinary(int[][] nums ,int target){

        if(nums == null || nums.length == 0 || nums[0].length == 0 ){
            return false;
        }
        int rows = nums.length,cols=nums[0].length;
        int row=0,col=cols-1;
        while(row<rows && col >=0){
            int num = nums[row][col];
            if(num == target){
                return true;
            }else if(num>target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }

}
