package com.example.leecode;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author vansn
 * @Date 2022/1/26 下午5:12
 * @Version 1.0
 * @Description 二叉树的中序遍历
 */
public class TwoTreeTraval {

    public List<Integer> inOrderTravel(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        inOrder(root,res);

        return res;
    }
    public void inOrder(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);
    }

}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
    }
}
