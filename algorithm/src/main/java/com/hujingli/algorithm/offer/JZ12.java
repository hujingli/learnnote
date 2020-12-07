package com.hujingli.algorithm.offer;

/**
 * 数值的整数次方
 */
public class JZ12 {


    public static void main(String[] args) {
        JZ12 jz12 = new JZ12();
//        System.out.println(jz12.Power(-2, 3));
        System.out.println(jz12.Power1(2, -3));
    }

    public double Power(double base, int exponent) {

        return Math.pow(base, exponent);

    }

    public double Power1(double base, int exponent) {
        if (base == 0) {
            return base;
        }
        if (exponent == 0) {
            return 1.0;
        }
        if (exponent < 0) {
            base = 1 / base;

            exponent = -exponent;
        }
        double result = base;
        for (int i = 1; i < exponent; i++) {
            base *= result;
        }
        return base;
    }

}
