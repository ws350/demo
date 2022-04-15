package com.example.leecode.sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author vansn
 * @Date 2022/2/21 下午3:34
 * @Version 1.0
 * @Description
 */
public class LeverOrder2 {

    public List<List<Integer>> leverOrder(TreeNode1 root){
        Queue<TreeNode1> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i=queue.size();i>0;i--){
                TreeNode1 node = queue.poll();
                temp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return  res;
    }

    //之字形打印
    public List<List<Integer>> leverOrder2(TreeNode1 root){

        Queue<TreeNode1> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            LinkedList<Integer> temp = new LinkedList<>();
            for(int i = queue.size();i>0;i--){
                TreeNode1 node = queue.poll();
                //偶数层 队列头部
                if(res.size()%2 ==0) temp.addLast(node.val);
                else temp.addFirst(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}
