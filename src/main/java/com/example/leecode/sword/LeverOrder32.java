package com.example.leecode.sword;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author vansn
 * @Date 2022/2/21 上午11:24
 * @Version 1.0
 * @Description  从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class LeverOrder32 {

    int[] nums= new int[1000];
    Queue<TreeNode1> queue = new LinkedList<TreeNode1>();
    public  int[] leverOrder(TreeNode1 node){

        if(node == null) return nums;
        treeTravel(node);
        int i=0;
        for(TreeNode1 node1:queue){
            nums[i++] = node1.val;
        }
        return nums;
    }

    public  void treeTravel(TreeNode1 node){
        if(node == null) return;
        queue.add(node);
        if(node.left != null) leverOrder(node.left);
        if(node.right!= null) leverOrder(node.right);

    }
}


class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1() {}
    TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}