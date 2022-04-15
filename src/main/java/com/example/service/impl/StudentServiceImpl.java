package com.example.service.impl;

import com.example.dao.StudentMapper;
import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author vansn
 * @Date 2022/3/25 上午11:20
 * @Version 1.0
 * @Description
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    public StudentMapper studentMapper;


    @Override
    public void insertStu(Student student) {
        studentMapper.insertStu(student);
    }
}
