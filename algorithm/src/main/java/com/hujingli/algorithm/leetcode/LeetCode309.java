package com.hujingli.algorithm.leetcode;

public class LeetCode309 {

    public static void main(String[] args) {
        LeetCode309 code309 = new LeetCode309();
//        System.out.println(code309.maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(code309.minStep(12));
    }


    // 1 2 3 0 2
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int[][] dp = new int[prices.length][3];

        dp[0][0] = -prices[0]; // ����һ֧��Ʊ  �п�����������ģ� Ҳ�п����ǽ������
        dp[0][1] = 0; // �����й�Ʊ  �ҵ�����������䶳��  �п������������ģ�Ҳ�п������첻����
        dp[0][2] = 0; // �����й�Ʊ ������������䶳��  �п����ǽ�����Ľ������ģ�Ҳ�п�����������еģ���������

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = dp[i - 1][0] + prices[i];
        }

        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);

    }


    public int minStep(int n) {

        int[][] dp = new int[n+1][3];
        dp[1][0] = 1;
        dp[1][1] = Integer.MAX_VALUE;
        dp[1][2] = Integer.MAX_VALUE;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(Math.min(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]) + 1;
            if (i % 2 == 0) {
                dp[i][1] = Math.min(Math.min(dp[i / 2][0], dp[i / 2][1]), dp[i / 2][2]) + 1;
            } else {
                dp[i][1] = Integer.MAX_VALUE;
            }

            if (i % 3 == 0) {
                dp[i][2] = Math.min(Math.min(dp[i / 3][0], dp[i / 3][1]), dp[i / 3][2]) + 1;
            } else {
                dp[i][2] = Integer.MAX_VALUE;
            }
        }
        return Math.min(Math.min(dp[n][0], dp[n][1]),dp[n][2]);

    }



}
