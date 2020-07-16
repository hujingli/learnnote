package com.hujingli.vjudge.ap;

import java.util.*;

/**
 * 算数级数问题
 */
public class Ap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] arr = new int[n];



            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            Arrays.sort(arr);

            if (n==1){
                System.out.println(-1);
                continue;
            }
            if (n==2){
                int num = 2;
                int ap = arr[1] - arr[0];
                int ap2 = -1;
                if (ap%2==0){
                     ap2 = ap / 2;
                    num = 3;
                }
                List<Integer> aps = new ArrayList<>();
                if (num == 3){
                    if (ap == 0){
                        num = 1;
                        aps.add(arr[1] - ap2);
                    }else{
                        aps.add(arr[1] - ap2);
                        aps.add(arr[0] - ap);
                        aps.add(arr[1] + ap);
                    }

                }else{
                    aps.add(arr[0] - ap);
                    aps.add(arr[1] + ap);
                }
                Collections.sort(aps);
                System.out.println(num);
                for (int i = 0; i < aps.size(); i++) {
                    System.out.print(aps.get(i) + " ");
                }
                continue;
            }
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();

            for (int i = 0; i < arr.length-1; i++) {
                // 先求等差值
                map.merge(arr[i+1]-arr[i], 1, Integer::sum);
            }

            // 超过两个以上的值则表明无法形成等差数列
            if (map.size() > 2){
                System.out.println(0);
                continue;
            }

            // 只有一个等差值
            if (map.size() == 1){
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                Integer ap = iterator.next().getKey();
                int num = 1;
                List<Integer> aps = new ArrayList<>();
                aps.add(arr[0] - ap);
                if((arr[0] - ap ) != (arr[arr.length -1] + ap)){
                    num = 2;
                    aps.add(arr[arr.length-1] + ap);
                }

                Collections.sort(aps);
                System.out.println(num);
                for (Integer integer : aps) {
                    System.out.print(integer + " ");
                }
                continue;
            }

            // 有两个等差值
            if (map.size() == 2){
                List<Integer> aps = new ArrayList<>();
                for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                    int ap = entry.getKey();
                    aps.add(ap);
                }
                Collections.sort(aps);
                if ((map.get(aps.get(0)) == map.get(aps.get(1)) && map.get(aps.get(0)) > 1) || (map.get(aps.get(1)) != 1) ){
                    System.out.println(0);
                    continue;
                }

                int ap = aps.get(0);
                boolean flag = false;
                for (int i = 0; i < n - 1; i++) {
                    if (arr[i+1] - arr[i] != ap){
                        if ((arr[i] + ap) == (arr[i+1] - ap) ){
                            System.out.println(1);
                            System.out.print(arr[i] + ap);
                            flag = true;
                        }
                    }
                }
                if (!flag){
                    System.out.println(0);
                }


            }

        }
    }

}
