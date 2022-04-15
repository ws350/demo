package com.example.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author vansn
 * @Date 2022/2/14 上午8:58
 * @Version 1.0
 * @Description 华为面试题
 * 小组中有多个人，每个人手中有一个卡片，卡片上是6位内的正整数，将卡片连接起来可以组成多个数字，计算可以组成的最大数字。
 * 示例 输入 22,221
 * 示例 输出 22221
 */
public class MostNum {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] str = sc.next().split(",");
            List<String> list = new ArrayList<String>();
            list = Arrays.asList(str);
            //本题精髓：数组排序  长度相等，直接比较，长度不等，拼接后比较
            list.sort((o1, o2) -> o1.length()==o2.length()?o2.compareTo(o1):(o2+o1).compareTo(o1+o2));
            StringBuilder  sb = new StringBuilder();
            for(String s:list){
                sb.append(s);
            }
            System.out.println(sb);
        }


    }

}
