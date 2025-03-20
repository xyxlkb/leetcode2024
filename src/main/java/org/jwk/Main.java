package org.jwk;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5}; // 初始化数组

        Arrays.sort(arr); // 从小到大排序
        Arrays.sort(arr, Collections.reverseOrder());

        for (int i : arr) {
            System.out.println(i);
        }

    }

}