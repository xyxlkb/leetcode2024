package org.jwk;

import java.util.ArrayList;
import java.util.List;

public class lc132_minCut {
    public static void main(String[] args) {
        Solution132 solution132 = new Solution132();
        System.out.println(solution132.minCut("aab"));
    }

}

class Solution132 {
    int minCutTime = 2000;
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

        return minCutTime;
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