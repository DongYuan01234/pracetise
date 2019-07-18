package com.guozz.test.thread.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author guozhizhong
 * @Title: SemaphoreTest
 * @ProjectName practise-thread
 * @Description: TODO
 * @date 2019/5/204:28 PM
 **/
public class SemaphoreTest {

    public static void main(String[] args) {
        //8个人
        int N=8;
        //5个机器
        Semaphore semaphore= new Semaphore(5);

        for(int i=0;i<N;i++){
            new Worker(i,semaphore).start();
        }
    }

    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;
        public Worker(int num,Semaphore semaphore){
            this.num=num;
            this.semaphore=semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人"+this.num+"占用一个机器正在生产");
                Thread.sleep(2000);
                System.out.println("工人"+this.num+"释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
