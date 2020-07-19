package com.example.demo.concurrent;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Henry
 * @date 2020-1-14 13:51
 */
public class CallableTest implements Callable {

    @Override
    public Object call() throws Exception {
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = new ThreadPoolExecutor(
//                5, 10, 1, TimeUnit.SECONDS,
//                new LinkedBlockingDeque<>());
//        for (int i = 0; i<5; i++)
//            System.out.println(executorService.submit(new CallableTest()).get());
//        executorService.shutdown();
        CallableTest test = new CallableTest();
        FutureTask futureTask = new FutureTask(test);
        FutureTask futureTask1 = new FutureTask(test);
        new Thread(futureTask).start();
        new Thread(futureTask1).start();

        System.out.println(futureTask.get());
        System.out.println(futureTask1.get());

    }
}
