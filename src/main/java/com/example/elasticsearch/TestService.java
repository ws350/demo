package com.example.elasticsearch;

import java.util.List;

/**
 * @author xiaoma
 * @desc ...面向接口编程
 * @date 2021-05-20 16:03:24
 */
public interface TestService {
    Iterable<TestBean> findAll();

    void save(List<TestBean> list);

    void save(TestBean bean);

    List<TestBean> findByName(String text);

    List<TestBean> findByNameOrDesc(String name);
}


