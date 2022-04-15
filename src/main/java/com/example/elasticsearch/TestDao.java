package com.example.elasticsearch;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xiaoma
 * @desc ...继承CRUD，第一个泛型是实体类类型，第二个泛型是id的类型
 * @date 2021-05-20 16:01:45
 */

public interface TestDao extends CrudRepository {
    List<TestBean> findByName(String name);

    List<TestBean> findByNameOrDesc(String text);
}
