package com.hujingli.vjudge;

import java.util.List;

public class AscallDecoder {

    public static void main(String[] args) {
        String str = "146154141147173123160104142137120171137163143162151160164137117164143137124157137124145156137101163143151151175";

        System.out.println((int)'a');
        System.out.println(141 - 97);
        System.out.println((char)(146-44));
        System.out.println((int)'}');
        System.out.println(175-125);
        System.out.println((char)160);

        StringBuilder result = new StringBuilder();
        int index = 0;
        for (char c : str.toCharArray()) {
            result.append(c);
            index++;
            if (index % 3 == 0) {
                System.out.print((char)(Integer.parseInt(result.toString())-44));
                result = new StringBuilder();
            }
        }
    }

}
