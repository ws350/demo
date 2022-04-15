package com.example.javafunction.juc.Stream1;

import com.example.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-10-08 18:02:52
 */
public class Demo1 {
    public static void main(String[] args) {
        User user1 = new User(0,"aa1",10);
        User user2 = new User(1,"aa2",20);
        User user3 = new User(2,"aa3",30);
        User user4 = new User(3,"aa4",40);
        User user5 = new User(4,"aa5",50);
        List<User> list = Arrays.asList(user1,user2,user3,user4,user5);
        list.stream()
                .filter(u->{return u.getId()%2==0;})
                .filter(u->{return u.getAge()>23;})
                .map(u->{return u.getUserName().toUpperCase();})
                .sorted((u1,u2)->{return u1.compareTo(u2);})
                .limit(2)
                .forEach(System.out::println);
    }

}
