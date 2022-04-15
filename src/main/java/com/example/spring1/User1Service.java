package com.example.spring1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
    @desc ...
    @date 2021-09-22 10:04:49
    @author xiaoma
*/
@Service
public class User1Service {
    @Resource
    private User1Dao1 user1Dao1;

    public List<User1> queryUserList(){
        return null;
    }
}
