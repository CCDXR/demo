package com.example.demo.concurrent.aqs;

import java.util.concurrent.CountDownLatch;

/**
 * @author Henry
 * @date 2020-5-29 13:19
 */
public class CdlConcurrencyService implements Service{

    CountDownLatch begin;
    CountDownLatch start;
    CountDownLatch end;

    public CdlConcurrencyService(CountDownLatch begin, CountDownLatch start, CountDownLatch end) {
        this.begin = begin;
        this.start = start;
        this.end = end;
    }


    @Override
    public void doService() {
        begin.countDown();
        try {
            System.out.println("CdlConcurrencyService:"+Thread.currentThread().getName()+"wait to Start!");
            start.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CdlConcurrencyService:"+Thread.currentThread().getName()+" Start!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CdlConcurrencyService:"+Thread.currentThread().getName()+" End!");
        end.countDown();
    }
}
