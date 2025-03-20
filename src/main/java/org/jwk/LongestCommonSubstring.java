package org.jwk;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfce";
        System.out.println(longestCommonSubstring(s1, s2)); // 输出 2
    }

    public static int longestCommonSubstring(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1]; // dp[i][j] 表示以 s1[i-1] 和 s2[j-1] 结尾的最长公共子串长度
        int maxLen = 0; // 记录最长公共子串的长度

        // 填充 dp 表
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // 状态转移
                    maxLen = Math.max(maxLen, dp[i][j]); // 更新最大值
                } else {
                    dp[i][j] = 0; // 不匹配时长度为 0
                }
            }
        }

        return maxLen;
    }


}