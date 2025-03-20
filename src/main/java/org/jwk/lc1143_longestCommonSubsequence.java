package org.jwk;

public class lc1143_longestCommonSubsequence {
}

class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        // dp[i][j]：到text1.i text2.j为止，最长的公共子序列长度，不要求一定要用到text1.i或text2.j
        // 可以从左边，上面，左上角继承，如果text1.i text2.j相同，就从左上角+1继承
        int[][] dp = new int[len1 + 1][len2 + 1];
        if (text1.charAt(0) == text2.charAt(0))
            dp[0][0] = 1;
        else
            dp[0][0] = 0;
        for (int i=1; i<len1; i++) {
            if (text1.charAt(i) == text2.charAt((0)))
                dp[i][0] = 1;
            else dp[i][0] = dp[i-1][0];
        }
        for (int j=1; j<len2; j++) {
            if (text1.charAt(0) == text2.charAt((j)))
                dp[0][j] = 1;
            else dp[0][j] = dp[0][j-1];
        }

        for (int i=1; i<len1; i++) {
            for (int j=1; j<len2; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]); //从上面和左边继承一个大的
                if (text1.charAt(i) == text2.charAt(j)) //如果相同的话，就可以从左上角继承
                    dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i][j]);
            }
        }
        return dp[len1-1][len2-1];
    }
}