package com.example.javafunction.threadpool;



import java.util.concurrent.*;

/**
 * @Description
 * @Author: vansn
 * @Date: 2022/1/7 下午5:34
 */
public class ThreadFuture {

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        Task task = new Task() ;
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        service.submit(futureTask);
        service.shutdown();
        System.out.println("主线程正在执行任务");
        try{
            System.out.println("----");
            System.out.println("执行结果为"+futureTask.get());
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
        System.out.println("任务执行完成");


    }

    static class Task implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            try{
                System.out.println("线程开始执行任务");
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            int num = 0;
            for(int i = 0;i<100;i++){
                num +=i;
            }

            return num;
        }
    }
}
