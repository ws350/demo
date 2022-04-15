package com.example.service.impl;

import com.example.dao.StudentMapper;
import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author vansn
 * @Date 2022/3/25 下午3:37
 * @Version 1.0
 * @Description
 */

public class StudentServiceImpl2 implements StudentService {
    @Resource
    public StudentMapper studentMapper;


    @Override
    public void insertStu(Student student) {
       System.out.println("student 2");
    }
}
