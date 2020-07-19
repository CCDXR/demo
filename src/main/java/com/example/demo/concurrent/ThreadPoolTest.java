package com.example.demo.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest implements Runnable{
    private long time;
    private static ThreadPoolExecutor threadPool =
            new ThreadPoolExecutor(15,
                    20,
                    10,
                    TimeUnit.SECONDS,
                    new ArrayBlockingQueue(100));

    public ThreadPoolTest(long time) {
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"start!");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"stop!");
    }

    public static void main(String[] args) {
        for (int i = 0; i<50;i++) {
            threadPool.execute(new ThreadPoolTest((long) (Math.random()*1000)));
        }
        threadPool.shutdown();
        while(!threadPool.isTerminated()) {

        }
        System.out.println("main thread die!");
    }
}
