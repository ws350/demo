package com.example.javafunction;

/**
 * @Author vansn
 * @Date 2022/1/25 下午8:46
 * @Version 1.0
 * @Description
 */
public class CharacterTest {
    public static void main(String[] args){
      String s= "abcdefg";
      char a = 'd';
      for(int i=0;i<s.length();i++){
          if(a == s.charAt(i)){
              System.out.println(i);
          }
      }

    }
}
