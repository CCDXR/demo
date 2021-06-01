package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {

    volatile int[] arr;
    public static void main(String[] args) {
        boolean bool = 0.2+0.4 == 0.6;
        System.out.println(bool);


        System.out.println(111/2);

        Main m = new Main();
        System.out.println(m.hashCode());


        String x = "http://10.12.107.33";
        System.out.println(x.substring(7));

        String s3 = new String("1") + new String("1");
        String s5 = s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
        System.out.println(s4 == s5);




        int h;
        System.out.println(("gg".hashCode()));
        System.out.println(new Object().hashCode());




        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        System.out.println(-128+200-127-1);
        int i = 200;
        byte b = (byte) i;
        System.out.println(b);


//        Main m = new Main();
        int [] nums1 = new int[] {1,3};
        int [] nums2 = new int[] {2};
        System.out.println(m.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int [] ret = new int [len1+len2];
        int index = 0;
        for (int i= 0; i< len1; i++) {
            ret[index] = nums1[i];
            index++;
        }
        for (int i= 0; i< len2; i++) {
            ret[index] = nums2[i];
            index++;
        }
        Arrays.sort(ret);
        if ((len1 + len2)%2 == 0 ) {
            return (ret[(len1+len2)/2]+ret[(len1+len2)/2-1])/2.0;
        } else {
            return ret[(len1+len2)/2];
        }

    }
}
