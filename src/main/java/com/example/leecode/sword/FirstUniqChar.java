package com.example.leecode.sword;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author vansn
 * @Date 2022/2/21 上午10:13
 * @Version 1.0
 * @Description 第一个不重复字符
 */
public class FirstUniqChar {

    public static char firstUniqChar(String s){
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!map.containsKey(s.charAt(i))){
                map.put(ch,1);
            }else{
                map.put(ch,map.get(ch)+1);

            }
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i)) == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
