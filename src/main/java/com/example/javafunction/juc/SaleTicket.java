package com.example.javafunction.juc;

/**
 * @author xiaoma
 * @desc 卖票
 * @date 2021-09-22 11:25:50
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        //runnable 是一个functioniInterface 函数式接口，lambda表达式（参数）-》{代码}
        //new Thread(()->{}).start();
        new Thread(()->{
            for(int i=0;i<40;i++){
                ticket.sale();
            }

        },"A").start();
        new Thread(()->{
            for(int i=0;i<40;i++){
                ticket.sale();
            }
        },"B").start();
        new Thread(()->{
            for(int i=0;i<40;i++){
                ticket.sale();
            }
        },"C").start();
    }

}


class Ticket {
    private int number = 50;

    //卖票的方式
    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "票，剩余"+
                    number);

        }
    }
}
