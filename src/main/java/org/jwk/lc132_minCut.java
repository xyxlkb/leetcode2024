package org.jwk;

import java.util.ArrayList;
import java.util.List;

public class lc132_minCut {
    public static void main(String[] args) {
        Solution132 solution132 = new Solution132();
        System.out.println(solution132.minCut("leet"));
    }

}

class Solution132 {
    boolean[][] isHuiWen;

    public int minCut(String s) {
        if (s.length() == 1 || s == null)
            return 0;
        int n = s.length();
        isHuiWen = new boolean[n][n];
        initisHuiWen(n);
        for (int i=n-1; i>=0; i--) {
            for (int j=i+1; j<n; j++)
                if (s.charAt(i) == s.charAt(j) && isHuiWen[i+1][j-1])
                    isHuiWen[i][j] = true;
        }

        int[] dp = new int[n]; //dp[i] 表示从0到i的字母，最少分割几次，可以让全部是回文串
        dp[0] = 0;
        for (int right=1; right<n; right++) {
            if (isHuiWen[0][right]) {
                dp[right] = 0;
                continue;
            }

            int min = 2000;
            for (int left=1; left<=right; left++) { //在left位置的左边切一刀
                if (isHuiWen[left][right] && dp[left-1]+1<min)
                    min = dp[left-1] + 1;
            }
            dp[right] = min;
        }

        return dp[n-1];
    }



    private void initisHuiWen(int n) {
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++)
                isHuiWen[i][j] = false;
            for (int j=0; j<=i; j++)
                isHuiWen[i][j] = true;
        }
    }
}