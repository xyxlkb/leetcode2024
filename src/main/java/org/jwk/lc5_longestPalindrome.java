package org.jwk;

public class lc5_longestPalindrome {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome("aaaa"));
    }
}

class Solution5 {
    public String longestPalindrome(String s) {
        if (s==null || s.length()==1)
            return s;
        int maxLen = 1;
        int maxStart = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; //dp[i][j]表示从i到j是不是回文串

        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                dp[i][j] = false;

        for (int i=0; i<n; i++) { //长度为1的肯定是回文串
            dp[i][i] = true;
        }

        for (int len=2; len<=n; len++) { //循环子串长度，需要把每一个长度为len的都标记过
            for (int start=0; start<=n-len; start++) { //子串起点
                int end = start+len-1;
                if (s.charAt(start)==s.charAt(end)) {
                    if (dp[start+1][end-1] || len==2) { //长度为2的话前面比后面大，特殊处理
                        dp[start][end] = true;
                        maxStart = start;
                        maxLen = len; //因为len是从小到大训话的，所以不用判断是否大于maxLen
                    }
                }
            }
        }

        return s.substring(maxStart, maxStart+maxLen);
    }
}