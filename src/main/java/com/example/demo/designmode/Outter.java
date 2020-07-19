package com.example.demo.designmode;

public class Outter {
    private String outField = "outterf";
    private String field = "outter";

    public Outter() {}

    public Outter(String outField) {
        this.outField = outField;
    }

    public void print() {
        System.out.println(field);
    }


    public class Inner{
        private String inner = "innerf";
        private String field = "inner";

        public void print() {
            System.out.println(field);
        }

    }

}
