package com.example.demo.concurrent;

import java.util.concurrent.atomic.AtomicReference;

public class MyLock {
    private AtomicReference<Thread> cas = new AtomicReference<>();
    /*可重入，即设置一个锁计数器*/
    private int count;

    /*持有锁时间过长会导致其他线程占用太多cpu时间*/
    /*非公平锁，会存在线程饥饿问题*/
    public void Lock() {
        Thread current = Thread.currentThread();
        if (current == cas.get()) {
            count++;
            return;
        }
        while(!cas.compareAndSet(null, current)) {

        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        if (current == cas.get()) {
            if (count > 0) {
                count--;
            } else {
                cas.compareAndSet(current, null);
            }
        }
    }

}
