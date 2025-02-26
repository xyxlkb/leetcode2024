package org.jwk;

import java.sql.SQLOutput;

public class lc238_productExceptSelf {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        Solution238 solution = new Solution238();
        int[] res = solution.productExceptSelf(a);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            System.out.print(" ");
        }
    }

}

class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        int curproduct = 1;
        for (int i = 0; i < n; i++) {
            left[i] = nums[i] * curproduct;
            curproduct = left[i];
        }
        curproduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = nums[i] * curproduct;
            curproduct = right[i];
        }
        res[0] = right[1];
        res[n-1] = left[n-2];
        for (int i=1; i<n-1; i++) {
            res[i] = left[i-1] * right[i+1];
        }
        return res;
    }
}