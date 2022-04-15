package com.example.vansnutils;

import com.example.entity.User;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-10-09 22:45:07
 */
public class ObjectCountSize {

    public static void main(String[] args) {
        User user = new User(10111,"asdfadsfasdfasdfasdfasdfasd",6);
        System.out.println(count(user));
    }

    public static int count(Object o){
        int bytesize = 0;
        try{
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(baos);
            os.writeObject(o);
            os.close();
            bytesize=baos.size();
            System.out.println("o的大小为" + bytesize);
            baos.close();


        }catch (Exception e){
            e.printStackTrace();
        }

        return bytesize;
    }
}
