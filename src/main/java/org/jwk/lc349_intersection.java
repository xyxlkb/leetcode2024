package org.jwk;

import java.util.*;

public class lc349_intersection {
    public static void main(String[] args) {
        Solution349 solution = new Solution349();
        int[] res = solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Arrays.sort(nums1); ///两个都排序，这样就能按顺序找了
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();

        int p1 = 0, p2 = 0;
        while (p1 < len1 && p2 < len2) {
            while (p1 < len1-1 && nums1[p1] == nums1[p1+1])
                p1++;
            while (p2 < len2-1 && nums2[p2] == nums2[p2+1])
                p2++;

            if (nums1[p1] == nums2[p2]) {
                res.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}