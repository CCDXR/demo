package com.example.demo.concurrent;

import org.apache.commons.lang3.StringUtils;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GetUnsafe {
    public static void main(String[] args) {
        Class clazz = Unsafe.class;
        try {
            Field f = clazz.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(clazz);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        List l = new ArrayList<>();
        String.join("dd", l);
    }
}
