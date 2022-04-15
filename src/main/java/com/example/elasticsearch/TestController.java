package com.example.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-05-20 16:08:43
 */

@RestController
@RequestMapping("/es")
public class TestController {
    @Autowired
    TestService testService;

    @RequestMapping("/findByname")
    public List<TestBean> findByname(String name){
        return testService.findByName(name);
    }
}
