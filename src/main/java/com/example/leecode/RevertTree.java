package com.example.leecode;

/**
 * @Author vansn
 * @Date 2022/2/11 下午2:47
 * @Version 1.0
 * @Description  翻转二叉树
 */
public class RevertTree {



    public static TreeNode revertTree(TreeNode node){
        return revert(node);


    }

    public static TreeNode revert(TreeNode node){
        if(node.right == null && node.left == null){
            return null;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        if(node.right != null){
            revert(node.right);
        }
        if(node.left != null){
            revert(node.left);
        }
        return node;
    }

}
