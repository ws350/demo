package com.example.entity;

import java.io.Serializable;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 14:39
 */
public class User implements Serializable {
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;
    private Integer age;

    public User(Integer id,String userName,Integer age){
        this.setId(id);
        this.setAge(age);
        this.setUserName(userName);
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getRealName() {
        return age;
    }

    public void setRealName(Integer realName) {
        this.age = realName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", age ='" + age + '\'' +
                '}';
    }
}
