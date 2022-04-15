package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import com.example.service.impl.StudentServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author vansn
 * @Date 2022/3/25 上午11:21
 * @Version 1.0
 * @Description
 */

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;



    @PostMapping("/insert")
    public void insertStu(@RequestBody Student student){
        studentService.insertStu(student);
    }
}
