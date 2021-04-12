package com.hujingli.algorithm.baicizhan;

import java.util.HashMap;
import java.util.Map;

public class ZipStr {


    public static void main(String[] args) {
        ZipStr zipStr = new ZipStr();
        System.out.println(zipStr.zipStr("aa"));
    }

    //aabccccaaa
    public String zipStr(String str){

        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            map.merge(str.charAt(i), 1, Integer::sum);
            if (i > 0 && str.charAt(i) != str.charAt(i - 1)) {
                Integer count = map.get(str.charAt(i - 1));
                sb.append(str.charAt(i - 1)).append(count == 1 ? "" : count);
                map.remove(str.charAt(i - 1));
            }
        }
        Integer count = map.get(str.charAt(str.length() - 1));
        sb.append(str.charAt(str.length() - 1)).append(count == 1 ? "" : count);
        return sb.toString();

    }


}
