package org.jwk;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String input = "5113保护定制";
        System.out.println(input.replaceAll("\\d+", ""));
//        System.out.println("Hello world!");
//        getNumberOrType(input);
    }

    public static void getNumberOrType(String currentLine) {
        if (currentLine.contains("装置编号")) {
            Pattern pattern = Pattern.compile("装置编号\\s*:?\\s*(\\S+)");
            Matcher matcher = pattern.matcher(currentLine);
            if (matcher.find()) {
                String deviceNumber = matcher.group(1); // 获取第一个匹配的组（即\S+匹配的部分）
                System.out.println(deviceNumber);
            }
        }
        else if (currentLine.contains("装置型号") || currentLine.contains("保护型号")) {
            Pattern pattern = Pattern.compile("装置型号\\s*(\\S+)");
            Matcher matcher = pattern.matcher(currentLine);
            if (matcher.find()) {
                String deviceNumber = matcher.group(1); // 获取第一个匹配的组（即\S+匹配的部分）
                System.out.println(deviceNumber);
            }
        }
    }
}