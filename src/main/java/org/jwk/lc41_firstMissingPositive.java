package org.jwk;

public class lc41_firstMissingPositive {
    public static void main(String[] args) {
        Solution41 solution41 = new Solution41();
        int[] a = {7,8,9,11,12};
        System.out.println(solution41.firstMissingPositive(a));
    }
}

class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] appeared = new boolean[100003];
        for (int i=0; i<100002; i++) appeared[i] = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) continue;
            if (nums[i] > 100000) continue;
            appeared[nums[i]] = true;
        }
        for (int i = 1; i < 100003; i++) {
            if (!appeared[i]) return i;
        }
        return 1;
    }
}