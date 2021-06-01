package com.example.demo.designmode;

public interface Service1 {
    default void run() {
        System.out.println("service1 run");
    }
    default void ah() {
        System.out.println("agh");
    }
    static void ss() {
        System.out.println("ss");
    }
    static void dd() {}
}
