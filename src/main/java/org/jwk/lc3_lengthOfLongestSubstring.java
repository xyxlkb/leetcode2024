package org.jwk;

public class lc3_lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = " ";
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring(s));
    }

}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLength = 0;
        int n = s.length();
        boolean[] used = new boolean[256];
        int left = 0, right = 0;
        while (right < n) {
            if (!used[(int)s.charAt(right)]) {
                used[(int)s.charAt(right)] = true;
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                used[(int)s.charAt(left)] = false;
                left++;
            }
        }

        return maxLength;
    }
}