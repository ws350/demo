package com.example.leecode.sword;

/**
 * @Author vansn
 * @Date 2022/2/17 下午2:47
 * @Version 1.0
 * @Description 替换空格
 */
public class ReplaceSpace05 {

    public static String replaceSpace(String s){
        if(s == null) return null;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                sb.append('%').append('2').append('0');
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }


    //用char[]实现  】
    public static String replaceSpace2(String s){
        int length = s.length();
        char[]  array = new char[length*3];
        int size = 0;
        for(int i = 0;i<length;i++){
            char c = s.charAt(i);
            if(c == ' '){
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            }else{
                array[size++] = c;
            }
        }
        String newstr = new String(array,0,size);
        return newstr;
    }
}
