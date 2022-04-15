package com.example.baguwen.cglib;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-09-20 22:43:39
 */
public class ProxyTest {

    @Test
    public void test1(){
        //创建目标对象---只有一个service
        Iwok iwok = new Iworkimpl();
        //创建切面类
        Advices advices = new Advices();
        //创建代理对象
        Iwok iwork_proxy = (Iwok) Proxy.newProxyInstance(iwok.getClass().getClassLoader(), iwok.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                advices.log();
                Object invoke = method.invoke(iwok,args);
                advices.transaction();
                return invoke;
            }
        });
        //iwork_proxy 就是代理类，iwok就是目标对象，iworkProxy实现了对iwok的增强
        iwork_proxy.service();
    }
}
