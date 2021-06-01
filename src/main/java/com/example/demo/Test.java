package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        int [] arr = {2,2,4,6,7,7,6,8};
        List<Integer> l = Arrays.stream(arr).boxed().collect(Collectors.toList());
        final List ll = l;
        ll.add(0, 1);

    }
}
