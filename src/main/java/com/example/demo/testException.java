package com.example.demo;

public class testException {
    public static void main(String[] args) {
        try{
            throw new RuntimeException("hahah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("main end!");
    }
}
