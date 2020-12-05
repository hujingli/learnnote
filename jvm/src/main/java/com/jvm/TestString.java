package com.jvm;

public class TestString {

    public static void main(String[] args) {
        int a = 9; // 1001 0110 0111 0001       0000 1000    1111 0111  +1     1111 1000
        int b = a & (~a + 1);
        System.out.println(b);
    }

}
