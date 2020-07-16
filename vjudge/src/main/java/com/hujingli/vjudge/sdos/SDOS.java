package com.hujingli.vjudge.sdos;

import java.util.Scanner;

/**
 * 六度分离理论 six degrees of separation   需要用到floyd算法
 */
public class SDOS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){

            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] dis = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        dis[i][j] = 0;
                    } else {
                        dis[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                dis[a][b] = 1;
                dis[b][a] = 1;
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (dis[i][k] + dis[k][j] < dis[i][j] && dis[i][k] != Integer.MAX_VALUE&& dis[k][j] != Integer.MAX_VALUE) {
                            dis[i][j] = dis[i][k] + dis[k][j];
                        }
                    }
                }
            }

            boolean flag = true;
            outer:
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dis[i][j] > 7) {
                        flag = false;
                        break outer;
                    }
                }
            }

            if (flag) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }


        }
    }

}
