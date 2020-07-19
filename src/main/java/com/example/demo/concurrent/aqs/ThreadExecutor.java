package com.example.demo.concurrent.aqs;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Henry
 * @date 2020-5-29 11:01
 */
public class ThreadExecutor implements Runnable {

    private Service service;

    private ThreadExecutor(Service service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SemaphoreService semaphoreService = new SemaphoreService();
        List<ThreadExecutor> threadExecutor = Stream.generate(() -> new ThreadExecutor(semaphoreService)).limit(10).collect(Collectors.toList());
        threadExecutor.forEach(a -> new Thread(a).start());

        CountDownLatch count = new CountDownLatch(1);
        CountDownLaunchService countDownLaunchService = new CountDownLaunchService(count);
        new Thread(new ThreadExecutor(countDownLaunchService)).start();
        try {
            System.out.println("Main Thread await!");
            count.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread end!");


        CountDownLatch begin = new CountDownLatch(5);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);
        CdlConcurrencyService cdlConcurrencyService = new CdlConcurrencyService(begin, start, end);
        List<ThreadExecutor> threadExecutors = Stream.generate(() ->
                new ThreadExecutor(cdlConcurrencyService)).limit(5).collect(Collectors.toList());
        threadExecutors.forEach(a -> new Thread(a).start());
        try {
            begin.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        start.countDown();
        try {
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread end!");

    }

    @Override
    public void run() {
        service.doService();
    }
}
