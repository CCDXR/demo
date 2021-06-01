package com.example.demo.collection;

import java.util.Arrays;

public class MyStack {
    private int [] data;
    private int count;
    private int capacity;

    private static final int GROW_FACTOR = 2;

    public MyStack() {
        count = 0;
        capacity = 2;
        data = new int [2];
    }

    public MyStack(int initialCapacity) {
        if (initialCapacity < 1) throw new RuntimeException("capacity too small");
        capacity = initialCapacity;
        data = new int[capacity];
    }

    public void push(int e) {
        if (count +1 > capacity)
            expanCapacity();
        data[count++] = e;
    }

    public int pop () {
        if (count < 1)
            throw new RuntimeException("no element");
        return data[--count];
    }

    public int peek () {
        if (count < 1)
            throw new RuntimeException("no element");
        return data[count -1];
    }

    private void expanCapacity() {
        capacity = capacity * GROW_FACTOR;
        data = Arrays.copyOf(data, capacity);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        myStack.push(8);
        System.out.println(myStack.peek());//8
        System.out.println(myStack.size());//8
        for (int i = 0; i < 8; i++) {
            System.out.println(myStack.pop());
        }
        System.out.println(myStack.isEmpty());//true
        myStack.pop();//报错：java.lang.IllegalArgumentException: Stack is empt
    }
}
