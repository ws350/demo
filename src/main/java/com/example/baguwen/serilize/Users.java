package com.example.baguwen.serilize;

import java.io.Serializable;

/**
 * @Author vansn
 * @Date 2022/1/26 下午10:06
 * @Version 1.0
 * @Description
 */
public class Users implements Serializable {

    public static final long serialVersionUID = 1l;
    private String userId;
    private String userName;
    private Integer age;

    public Users() {
    }

    public Users(String userId, String userName, Integer age) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
