package org.jwk;

import java.awt.image.AreaAveragingScaleFilter;
import java.rmi.server.RemoteObject;

public class lc213_rob {
}

class Solution213 {
    public int rob(int[] nums) {
        if (nums == null)
            return 0;
        int n = nums.length;
        if (n == 1)
            return nums[0];

        int[] array = new int[n-1]; //对前n-1个和后n-1个分别进行一次之前的dp操作，就是不成环的打家劫舍
        for (int i=0; i<n-1; i++)
            array[i] = nums[i];
        int max = robHelp(array);
        for (int i=0; i<n-1; i++)
            array[i] = nums[i+1];
        max = Math.max(max, robHelp(array));

        return max;
    }

    public int robHelp(int[] nums) {
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
