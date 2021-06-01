package com.example.demo.collection;

import java.util.concurrent.ArrayBlockingQueue;

public class QueueTest implements Runnable{
    /**
     * putIndex和takeIndex各自递增到尾则归零，维护两个index是为了先进先出，
     * put前循环判断length是否到达容量,到达则阻塞等待take进程唤醒
     */
    private static ArrayBlockingQueue queue = new ArrayBlockingQueue(5);
    private String operate;

    private QueueTest(String operate) {
        this.operate = operate;
    }

    public static void main(String[] args) {
        new Thread(new QueueTest("put")).start();
        new Thread(new QueueTest("take")).start();
    }

    @Override
    public void run() {
        if ("put".equals(operate)) {
            //模拟10个线程put
            for (int i = 0; i < 7; i++) {
                try {
                    System.out.println("put"+i);
                    //put阻塞是因为当前队列已满
                    queue.put("" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("put finished!");
        } else {
            //模拟10个线程take
            for (int i = 0; i < 1; i++) {
                try {
                    //take阻塞是因为当前队列已空
                    System.out.println("take"+queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("take finished!");
        }
    }

}
