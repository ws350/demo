package com.example.javafunction.list;

import org.mockito.internal.matchers.CompareTo;

import java.util.*;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-05-21 19:22:41
 */
public class ListTest {
    public static void main(String[] args) {
        List<String > list = new ArrayList<>();
        list.add("wangsheng");
        System.out.println(list.get(0));
       // list.sort();
        String s = "3",SS="4";
        System.out.println(s.compareTo(SS));


        List<Integer> linklist = new LinkedList<>();
        LinkedList<Integer> linklist2 = new LinkedList<>();
        linklist2.addFirst(1);
        linklist2.addFirst(2);
        linklist2.addLast(3);
        linklist2.addLast(4);

        Queue<Integer> linkqueue = new LinkedList<>();
        linkqueue.add(1);
        linkqueue.add(2);


    }


}
