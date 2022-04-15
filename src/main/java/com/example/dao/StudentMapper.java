package com.example.dao;

import com.example.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author vansn
 * @Date 2022/3/25 上午11:13
 * @Version 1.0
 * @Description
 */
@Mapper
public interface StudentMapper {

    void insertStu(@Param("student") Student student);
}
