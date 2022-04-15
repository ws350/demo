package com.example.baguwen.serilize;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

/**
 * @Author vansn
 * @Date 2022/1/26 下午10:40
 * @Version 1.0
 * @Description
 */
public class ReadUser {

    public static void main(String[] args){
        readUser();
    }
    private static void readUser(){
        Users user = null;
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(
                            new File("/Users/jojohu/Desktop/a.txt")));
            user = (Users) objectInputStream.readObject();
            System.out.println("反序列号后： id : "+
                    user.getUserId() +"     name:  "+user.getUserName()+"    age: "+user.getAge());
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
