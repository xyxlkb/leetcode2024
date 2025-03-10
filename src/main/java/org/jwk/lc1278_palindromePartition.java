package org.jwk;

public class lc1278_palindromePartition {
    public static void main(String[] args) {
        Solution1278 solution1278 = new Solution1278();
        System.out.println(solution1278.palindromePartition("ihhyviwv", 7));
    }
}

class Solution1278 {
    int[][] minStepsToPalindrome; //ij 表示最少改变几个字母可以让从i到j 变成回文串
    int[][] minSubStringToPalindrome; //ij 表示以i为结尾，最多分割成j个子串，使从0到i的每个子串都使回文串，需要改几个字母
    public int palindromePartition(String s, int k) {
        if (k >= s.length())
            return 0;
        int n = s.length();
        minStepsToPalindrome = new int[n][n];
        initminStepsToPalindrome(s);
/*        for (int i=0; i<n; i++) { //检测minStepsToPalindrome数组
            for (int j=0; j<n; j++)
                System.out.print(minStepsToPalindrome[i][j] + " ");
            System.out.println();
        }*/

        minSubStringToPalindrome = new int[n][k+1];
        initminSubStringToPalindrome(s, k);
        for (int right=0; right<n; right++) { //right表示结尾的地方
            for (int j=2; j<=k; j++) { //j表示分割次数
                if (right+1 <= j) //如果字母数量少于分割成的子串数，那肯定只用改0个
                    continue;
                minSubStringToPalindrome[right][j] = 101;
                for (int mid=j-2; mid<right; mid++) {
                    minSubStringToPalindrome[right][j] =
                            Math.min(minSubStringToPalindrome[mid][j-1]+minStepsToPalindrome[mid+1][right],
                                    minSubStringToPalindrome[right][j]); //尝试在mid的右边分割一次
                }
            }
        }
/*        for (int i=0; i<n; i++) { //检测minSubStringToPalindrome
            for (int j=1; j<=k; j++)
                System.out.print(minSubStringToPalindrome[i][j] + " ");
            System.out.println();
        }*/

        return minSubStringToPalindrome[n-1][k];
    }

    private void initminStepsToPalindrome(String s) {
        int n = s.length();
        for (int i=0; i<n; i++) {
            minStepsToPalindrome[i][i] = 0;
            for (int j=i+1; j<n; j++) {
                int left = i;
                int right = j;
                int minStep = 0;
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right))
                        minStep++;
                    left++;
                    right--;
                }
                minStepsToPalindrome[i][j] = minStep;
            }
        }
    }
    private void initminSubStringToPalindrome(String s, int k) {
        int n = s.length();
        for (int i=0; i<n; i++) { //以i为结尾的字符串
            minSubStringToPalindrome[i][1] = minStepsToPalindrome[0][i]; //分割成1个子串，相当于它自身改造为回文串所需次数
        }
    }
}
