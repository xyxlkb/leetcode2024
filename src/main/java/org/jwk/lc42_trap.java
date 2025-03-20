package org.jwk;

public class lc42_trap {
}

class Solution42 {
    public int trap(int[] height) {
        int sum = 0;
        int n = height.length;
        int[] leftMax = new int[n]; // 某列左边的列中最高的高度
        int[] rightMax = new int[n];

        for (int i=1; i<n; i++) {
            leftMax[i] = Math.max(height[i-1], leftMax[i-1]);
        }
        for (int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i+1], rightMax[i+1]);
        }

        for (int i=1; i<=n-2; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            if (minHeight > height[i])
                sum += minHeight - height[i];
        }

        return sum;
    }
}