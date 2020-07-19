package com.example.demo.concurrent;

/**
 * @author Henry
 * @date 2020-3-23 21:17
 */
public class Main implements Runnable{
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-1 << (Integer.SIZE -3)));

        Main m = new Main();
        Thread t1 = new Thread(m, "t1");
        Thread t2 = new Thread(m, "t2");
        t1.start();
        t2.start();

    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName()+"enter");
            try {
                wait(1000*2);
                System.out.println(Thread.currentThread().getName()+"exit");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
