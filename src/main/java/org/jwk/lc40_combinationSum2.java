package org.jwk;

import java.util.*;

public class lc40_combinationSum2 {
    public static void main(String[] args) {
        Solution40 solution = new Solution40();
        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}

class Solution40 {
    List<List<Integer>> res;
    int[] Candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Candidates = new int[candidates.length];
        for (int i = 0; i < candidates.length; i++) {
            Candidates[i] = candidates[i];
        }
        backTrack(target, 0, 0, new ArrayList<>());

        Set<List<Integer>> uniqueSet = new HashSet<>();
        for (List<Integer> list : res) {
            List<Integer> sortedList = new ArrayList<>(list);
            Collections.sort(sortedList);
            uniqueSet.add(sortedList);
        }

        List<List<Integer>> uniqueRes = new ArrayList<>(uniqueSet);
        return uniqueRes;
    }

    private void backTrack(int target, int curPos, int curSum, List<Integer> curRes) {
        if (curSum > target)
            return;
        if (curPos >= Candidates.length)
            return;
        if (curSum == target) {
            res.add(new ArrayList<>(curRes));
            return;
        }

        curSum += Candidates[curPos];
        curRes.add(Candidates[curPos]);
        backTrack(target, curPos + 1, curSum, curRes);
        curSum -= Candidates[curPos];
        curRes.remove(curRes.size() - 1);
        backTrack(target, curPos+1, curSum, curRes);
    }
}