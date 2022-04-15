package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
//@Repository
/*@Mapper
 * 1:为了把mapper这个DAO交給Spring管理
 * 2:为了不再写mapper映射文件
 * 3:为了给mapper接口 自动根据一个添加@Mapper注解的接口生成一个实现类
 * */
@Mapper
public interface UserMapper {

    User Sel(int id);


    void addUser(User user);


    void insertUser(@Param("User") User user);
}
