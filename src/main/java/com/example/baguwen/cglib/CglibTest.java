package com.example.baguwen.cglib;

import net.bytebuddy.build.ToStringPlugin;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-09-20 22:59:56
 */
public class CglibTest {

    @Test
    public void Test2(){
        //创建目标对象
        Iwork iwork = new Iwork();

        //切面类
        Advices advices = new Advices();

        //创建增强器
        Enhancer enhancer = new Enhancer();

        //设置目标类为父类
        enhancer.setSuperclass(iwork.getClass());

        //设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                advices.log();
                Object invoke = method.invoke(iwork,objects);
                advices.transaction();
                return  invoke;



            }
        });

        Iwork iwork_proxy = (Iwork) enhancer.create();
        iwork_proxy.service();


    }
}
