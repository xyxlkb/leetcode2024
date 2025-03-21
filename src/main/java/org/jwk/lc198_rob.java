package org.jwk;

public class lc198_rob {
}

class Solution198 {
    public int rob(int[] nums) {
        if (nums == null)
            return 0;
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int[] dp = new int[n]; //dp[i]表示只拿前i个最大值是多少，第i个人不是必须拿的
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i=2; i<n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}