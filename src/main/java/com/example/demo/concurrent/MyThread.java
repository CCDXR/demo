package com.example.demo.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread implements Runnable{
    private Object obj;

    public MyThread(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            int count = 5;
            while (count-- > 0) {
//                if (Thread.currentThread().getName().equals("thread3")) {
//                    obj.notifyAll();
//                    return;
//                }
                obj.notify();
                System.out.println(Thread.currentThread().getName()+ "wait");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+ "weak up");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        MyThread t1 = new MyThread(o);
        MyThread t2 = new MyThread(o);
        MyThread t3 = new MyThread(o);
        new Thread(t1, "thread1").start();
        new Thread(t2, "thread2").start();
//        Thread.sleep(1000);
//        new Thread(t3, "thread3").start();
    }
}
