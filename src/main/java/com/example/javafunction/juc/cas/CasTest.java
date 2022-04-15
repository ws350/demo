package com.example.javafunction.juc.cas;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author vansn
 * @Date 2022/4/12 上午9:09
 * @Version 1.0
 * @Description
 */
public class CasTest {




    private volatile int state = 0;
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    //private static final long stateOffset = 0;
    static {
        try {
             final long stateOffset = unsafe.objectFieldOffset(CasTest.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    public void dosomething(){
      //  if(unsafe.compareAndSwapInt(this,stateOffset,0,1)){

     //   }
    }


    public static void main(String[] args){
          AtomicInteger atInt;
       //   atInt.compareAndSet();
    }

}
