package com.example.leecode;

/**
 * @Author vansn
 * @Date 2022/2/14 上午10:57
 * @Version 1.0
 * @Description  二叉树直径
 */
public class BinaryTreeDiameter {

    int maxVal = 0;
    public  int binaryTreeDiameter(TreeNode node){
        int maxLen = 0;

        return maxVal;
    }

    //求树的深度
    public static int depth(TreeNode node){
        int maxVal = 0;
        if(node == null){
            return 0;
        }
        int LRight = depth(node.right);
        int LLeft = depth(node.left);

        maxVal = Math.max(LRight + LLeft,maxVal);
        return   Math.max(LLeft,LRight) +1;

    }


}
