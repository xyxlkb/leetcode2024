package org.jwk;

public class lc494_findTargetSumWays {
}

class Solution494 {
    int cnt = 0;
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        dfs(nums, target, 0, 0);
        return cnt;
    }

    private void dfs(int[] nums, int target, int curSum, int curIndex) {
        int n = nums.length;
        if (curIndex >= n)
            return;
        curSum += nums[curIndex]; //这个数字取正
        if (curIndex==n-1 && curSum == target) {
            cnt++;
        }
        dfs(nums, target, curSum, curIndex + 1);

        curSum -= nums[curIndex]*2; //这个数字取负
        if (curIndex==n-1 && curSum == target) {
            cnt++;
        }
        dfs(nums, target, curSum, curIndex + 1);
    }
}