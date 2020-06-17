package com.hujingli.vjudge.sdos;

import java.util.Scanner;

/**
 * 迪杰斯特拉算法
 */
public class Djstl {

    public static void main(String[] args) {
        int n, m; // n个顶点  m条边

        int x ; // x为要求的到最短路径的点

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextByte();
        x = scanner.nextInt();

        int[][] value = new int[n+1][n+1];

        int[] dis = new int[n + 1]; // 表示存最短的路径是多少

        // 初始化图  自己到自己的距离是0  其他的所有的默认为无穷大
        for (int i = 0; i < n + 1; i++) {
            dis[i] = Integer.MAX_VALUE; // 距离初始化为无穷大
            for (int j = 0; j < n + 1; j++) {
                if (i == j) {
                    value[i][j] = 0;
                }else {
                    value[i][j] = -1;
                }
            }
        }

        // m条边  赋值
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int v = scanner.nextInt();
            value[a][b] = v; // 从a -> b 的距离是v

            if (a == x){
                dis[b] = v;
            }

        }
        search(x, dis, value, n);

    }

    private static void search(int x, int[] dis, int[][] value, int n){
        boolean[] mark = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            mark[i] = false;
        }
        mark[x] = true;  // 表示当前点已经被加过了
        dis[x] = 0; // 自己到自己的距离是0

        int count = 1; // 表示当前已经加了几个点了
        while(count <= n){
            int loc = 0; // 表示贪心策略里面要加的那个点
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) { // 找loc
                if (!mark[i] && dis[i] < min){
                    min = dis[i];
                    loc = i;
                }
            }
            if (loc == 0){
                break; // 找完了
            }
            mark[loc] = true; // 标记当前点已经被找过了

            count ++;
            for (int i = 1; i <= n  ; i++) {
                if (!mark[i] && value[loc][i] != -1 && (dis[loc] + value[loc][i] < dis[i])){
                    dis[i] = dis[loc] + value[loc][i];
                }
            }
        }

        for (int i = 1; i < dis.length; i++) {
            if (dis[i] != Integer.MAX_VALUE){
                System.out.println("1->" + i +"的最短距离是:" + dis[i]);
            }else {
                System.out.println("1->" + i +"的最短距离是: 无法到达");
            }
        }


    }

}

/*
1 3 10
1 5 30
1 6 100
2 3 5
3 4 50
4 6 10
5 4 20
5 6 60
 */
