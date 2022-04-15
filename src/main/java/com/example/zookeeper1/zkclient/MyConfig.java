package com.example.zookeeper1.zkclient;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description
 * @Author: vansn
 * @Date: 2021/12/14 下午9:05
 */
@Data
@ToString
@NoArgsConstructor
public class MyConfig {

    private String key;
    private String name;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
