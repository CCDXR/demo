package com.example.demo.designmode;

public class Son extends Father implements Service{
    public static void main(String[] args) {
        double d = 0.2d;
        long l = (long) d;
        System.out.println(l);
        GrandFather son1 = new Son();
        son1.run();
        new Son().run();
        Father f = new Father();
        Son s = new Son();
        s = (Son) f;
        s.run();
//        f.run();
//        Service son = new Son();
//        son.run2();
//        son.run();



    }
}
