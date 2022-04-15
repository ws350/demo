package com.example.leecode;

/**
 * @Author vansn
 * @Date 2022/1/26 下午7:30
 * @Version 1.0
 * @Description  对称二叉树
 */
public class SymmetricTree {


    public boolean isSymmetric(TreeNode tree){
        if(tree.left ==null && tree.right == null){
            return  true;
        }
        if(tree.left==null || tree.left ==null){
            return false;
        }
        if(tree.left.val != tree.right.val){
            return false;
        }
        return isSymmetric(tree.left) && isSymmetric(tree.right);


    }



}
