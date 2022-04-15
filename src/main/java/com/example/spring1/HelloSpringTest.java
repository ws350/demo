package com.example.spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-09-22 08:57:25
 */
public class HelloSpringTest {

    public static void main(String[] args) {
        ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloSpringimpl hello = (HelloSpringimpl) application.getBean("hellospring");

        hello.sayHello();
    }
}
