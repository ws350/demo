package com.example.leecode;

/**
 * @Author vansn
 * @Date 2022/1/26 下午7:42
 * @Version 1.0
 * @Description 二叉树最大深度
 */
public class MaxDepth {


    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int leftlength = maxDepth(root.left);
            int rightlength = maxDepth((root.right));
            return Math.max(leftlength,rightlength)+1;
        }
    }
}
