package com.example.leecode.sword;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author vansn
 * @Date 2022/2/16 下午6:38
 * @Version 1.0
 * @Description
 */
public class CopyRandomList35 {

    Map<RandomNode,RandomNode> cacheNode = new HashMap<RandomNode,RandomNode>();

    public  RandomNode copyRandomList(RandomNode node){
        if(node ==null) return null;

        if(!cacheNode.containsKey(node)){
            RandomNode headnew = new RandomNode(node.val);
            cacheNode.put(node,headnew);
            headnew.next = copyRandomList(node.next);
            headnew.random = copyRandomList(node.random);
        }
        return cacheNode.get(node);
    }

}

class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
