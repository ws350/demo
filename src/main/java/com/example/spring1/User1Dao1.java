package com.example.spring1;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
    @desc ...
    @date 2021-09-22 09:55:21
    @author xiaoma
*/

//@Bean 只能用在方法上
@Component
public class User1Dao1 {

    public List<User1> queryUserList(){
        List<User1> res = new ArrayList<>();

        for(int i=0;i<10;i++){
            User1 user = new User1();
            user.setName("name"+ i);
            user.setAge(i);
            user.setPassword("password"+ i);
            res.add(user);
        }

        return res;
    }

}
