package org.jwk;

public class lc53_maxSubArray {
}

class Solution53 {
    public int maxSubArray(int[] nums) {
        int ans;
        int n = nums.length;
        int[] dp = new int[n]; //dp[i]表示到nums[i]为止的最大子数组和，i必须要选，因为需要是连续的
        dp[0] = nums[0];
        ans = dp[0];
        for (int i=1; i<n; i++) {
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]); //只能选择连上或者不连上
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}