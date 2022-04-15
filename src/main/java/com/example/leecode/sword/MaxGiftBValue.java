package com.example.leecode.sword;

/**
 * @Author vansn
 * @Date 2022/3/2 下午3:15
 * @Version 1.0
 * @Description 最大的礼物价值
 *
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 1/状态定义
 * 设动态规划矩阵dp，dp(i,j)代表当前节点（i，j）最大的累计价值
 * 2、根据动态规划 状态转移方程
 *  f(i,j) = max(f(i-1,j),f(i,j-1) + v(i,j)
 *  dp[0][0] = v[0][0]
 *
 *
 */
public class MaxGiftBValue {

    //暴力法？
    public static int maxValue(int[][] grid){
        int m = grid.length,n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               if(i==0 &&j==0) continue;
               if(i==0) grid[i][j] = grid[i][j] + grid[i][j-1];
               else if(j==0) grid[i][j] = grid[i][j] + grid[i-1][j];
               else grid[i][j] = grid[i][j] + Math.max( grid[i][j-1],grid[i-1][j]);
            }

        }
        return grid[m-1][n-1];
    }

}
