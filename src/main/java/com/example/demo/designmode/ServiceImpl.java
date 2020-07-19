package com.example.demo.designmode;

public class ServiceImpl implements Service, Service1 {

    private ServiceImpl() {
    }

    public static void main(String[] args) {
//        System.out.println(f(2));

        int hash = new ServiceImpl().hashCode();
        int i = hash &63;
        System.out.println(hash%64 == i);
    }

    private static <T extends Number & Comparable<? super T>> T min (T [] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        T min = arr[0];
        for (int i = 1; i< arr.length; i++) {
            if (min.compareTo(arr[i])>0) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int f(int value) {
        try {
            value = value / (value -2);
            return 100;
        } catch (Exception e) {
            e.printStackTrace();
            return value = value *2;
        } finally {
            if (value == 4) {
                return 0;
            }
        }
    }

    @Override
    public void run() {

    }
}
