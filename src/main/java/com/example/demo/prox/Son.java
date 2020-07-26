package com.example.demo.prox;

public class Son implements Father {
    @Override
    public void say() {
        System.out.println("Son say!");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
