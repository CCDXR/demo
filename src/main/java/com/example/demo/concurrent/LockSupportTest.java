package com.example.demo.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Henry
 * @date 2020-5-31 09:02
 */
public class LockSupportTest {

    /*park不需要获取某个对象的锁
    因为中断的时候park不会抛出InterruptedException异常，所以需要在park之后自行判断中断状态，然后做额外的处理*/
    public static void main(String[] args) {
        System.out.println("haha");
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            LockSupport.park();
            System.out.println(Thread.currentThread().getName()+Thread.interrupted());
            System.out.println("xixi");
        });
        LockSupport.unpark(t);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
        System.out.println(Thread.currentThread().getName()+Thread.interrupted());
        System.out.println("t"+t.isInterrupted());
        System.out.println("end");

    }

    void haha() {
        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
