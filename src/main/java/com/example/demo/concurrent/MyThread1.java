package com.example.demo.concurrent;

public class MyThread1 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +" 结束");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start");
        Thread t1 = new Thread(new MyThread1(), "mythread1");
        Thread t2 = new Thread(new MyThread1(), "mythread2");
        t1.start();
        t2.start();
        t1.join();
        System.out.println("main finished");
    }
}
