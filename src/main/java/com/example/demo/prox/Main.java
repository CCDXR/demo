package com.example.demo.prox;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Son son = new Son();
        System.out.println(son.clone());

        Father father = (Father) Proxy.newProxyInstance(
                son.getClass().getClassLoader(),
                son.getClass().getInterfaces(),
                (proxy, method, args1) -> {
                    System.out.println("enter proxy");
                    return method.invoke(son, args1);
                });
        father.say();

    }
}
