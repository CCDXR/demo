package com.example.demo.designmode;

public interface Service {
    String val1 = null;
    int val2 = 0;

    default void run() {
        System.out.println("Service run");
    }
    default void run2() {
        System.out.println("run2");
    }
    static void run1() {
        System.out.println("static");
    }
}
