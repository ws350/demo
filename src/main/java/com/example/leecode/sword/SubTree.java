package com.example.leecode.sword;

/**
 * @Author vansn
 * @Date 2022/3/1 上午11:02
 * @Version 1.0
 * @Description 树的子结构
 */
public class SubTree {

    public boolean isSubTree(TreeNode1 nodeA,TreeNode1 nodeB){
        return (nodeA!=null && nodeB!= null && (resur(nodeA,nodeB))&& isSubTree(nodeA.left,nodeB)&&isSubTree(nodeA.right,nodeB));
    }
    boolean resur(TreeNode1 nodeA,TreeNode1 nodeB){
        if(nodeB == null) return  true;
        if(nodeA == null || nodeA.val!= nodeB.val) return false;
        return resur(nodeA.left, nodeB.left) && resur(nodeA.right,nodeB.right);
    }

}
