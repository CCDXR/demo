package com.example.demo.concurrent.aqs;

import java.util.concurrent.CountDownLatch;

/**
 * @author Henry
 * @date 2020-5-29 11:13
 */
public class CountDownLaunchService implements Service {

    private CountDownLatch count;

    CountDownLaunchService(CountDownLatch count) {
        this.count = count;
    }

    @Override
    public void doService() {
        System.out.println("CountDownLaunchService:"+Thread.currentThread().getName()+" begin!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CountDownLaunchService:"+Thread.currentThread().getName()+" end!");
        count.countDown();
    }
}
