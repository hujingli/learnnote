package com.hujingli.algorithm.sort;

public class FindOdd {


    public static void main(String[] args) {

        // 找出出现基数次的数
        int[] arr = {1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 5, 5, 5, 5};

        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i]; // 最后的结果是  a ^ b   a和b即为数组中出现基数次的数
        }

        int onlyRightOne = eor & (~eor + 1); // 找出^结果最右侧的1的数  将 a  和  b分为两类

        int eorr = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & onlyRightOne) != 0) {  // 只对  最右侧结果为1的位置上的为1的数进行^
                eorr ^= arr[i];
            }
        }
        int another = eor ^ eorr;

        System.out.println("第一个结果是:" + eorr + ",第二个结果:" + another);

    }


}
