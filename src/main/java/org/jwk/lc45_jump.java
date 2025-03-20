package org.jwk;

public class lc45_jump {
}

class Solution45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = n+1;
        }

        for (int i=0; i<n; i++) {
            for (int step=0; step<=nums[i]; step++) {
                if (i+step>=n)
                    break;
                dp[i+step] = Math.min(dp[i+step], dp[i]+1);
            }
        }

        return dp[n-1];
    }
}