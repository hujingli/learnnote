package com.hujingli.algorithm.sort;

public class FindOdd {


    public static void main(String[] args) {

        // �ҳ����ֻ����ε���
        int[] arr = {1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 5, 5, 5, 5};

        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i]; // ���Ľ����  a ^ b   a��b��Ϊ�����г��ֻ����ε���
        }

        int onlyRightOne = eor & (~eor + 1); // �ҳ�^������Ҳ��1����  �� a  ��  b��Ϊ����

        int eorr = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & onlyRightOne) != 0) {  // ֻ��  ���Ҳ���Ϊ1��λ���ϵ�Ϊ1��������^
                eorr ^= arr[i];
            }
        }
        int another = eor ^ eorr;

        System.out.println("��һ�������:" + eorr + ",�ڶ������:" + another);

    }


}
