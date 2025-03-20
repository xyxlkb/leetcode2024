package org.jwk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc47_permuteUnique {
    public static void main(String[] args) {
        Solution47 solution = new Solution47();
        int[] nums = {1,1,2};
        List<List<Integer>> result = solution.permuteUnique(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}

class Solution47 {
    int n;
    boolean[] used;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        used = new boolean[n];
        Arrays.sort(nums);
        TraceBack(nums, n, new ArrayList<>());
        return res;
    }
    public void TraceBack(int[] nums, int remainingCount, ArrayList<Integer> cur) { // remainingCount means how many numbers need to be found
        if (remainingCount == 0) { //if there is enough numbers
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i=0; i<n; i++) {
            if (used[i])
                continue;
            if (i>0 && nums[i] == nums[i-1] && !used[i-1]) //if i-1's number is not chosed, means i's number is not we want
                continue;
            cur.add(nums[i]);
            used[i] = true;
            TraceBack(nums, remainingCount-1, cur);
            used[i] = false;
            cur.remove(cur.size()-1);
        }
    }
}