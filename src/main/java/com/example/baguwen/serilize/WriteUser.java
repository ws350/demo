package com.example.baguwen.serilize;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @Author vansn
 * @Date 2022/1/26 下午10:31
 * @Version 1.0
 * @Description
 */
public class WriteUser {

    public static void main(String[] args){
        writeUser();
    }

    private static void writeUser(){
       try{
           Users users = new Users("1","vansn",29);
           ObjectOutputStream objectOutputStream =
                   new ObjectOutputStream(
                        new FileOutputStream(
                           new File("/Users/jojohu/Desktop/a.txt")));
           objectOutputStream.writeObject(users);
           System.out.println("序列号成功");
           objectOutputStream.close();
       }catch (Exception e){
           e.printStackTrace();
       }

    }

}
