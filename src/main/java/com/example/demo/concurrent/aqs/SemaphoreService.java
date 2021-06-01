package com.example.demo.concurrent.aqs;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.concurrent.Semaphore;

/**
 * @author Henry
 * @date 2020-5-29 11:04
 */
public class SemaphoreService implements Service {

    private Semaphore semaphore = new Semaphore(1);

    @Override
    public void doService() {
        try {
            semaphore.acquire();
            System.out.println("SemaphoreService:"+Thread.currentThread().getName()+" begin!");
        } catch (InterruptedException e) {
            System.out.println(ExceptionUtils.getStackTrace(e));
        }finally {
            System.out.println("SemaphoreService:"+Thread.currentThread().getName()+" end!");
            semaphore.release();
        }
    }
}
