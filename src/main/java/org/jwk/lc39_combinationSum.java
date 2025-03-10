package org.jwk;

import java.util.ArrayList;
import java.util.List;

public class lc39_combinationSum {
    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        System.out.println(solution39.combinationSum(new int[]{2,3,5}, 8));
    }
}

class Solution39 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backTrack(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }

    /**
     * 回溯函数
     * @param candidates 候选数组
     * @param target     目标值
     * @param curPos     目前在数组中该取哪个数字了
     * @param curSum     目前取的所有数字的和
     * @param curRes     当前结果
     */
    private void backTrack(int[] candidates, int target, int curPos, int curSum, List<Integer> curRes) {
        if (curSum == target) {
            res.add(new ArrayList<>(curRes)); // 注意：需要新建一个 ArrayList
            return;
        }
        if (curSum > target)
            return;
        if (curPos >= candidates.length)
            return;

        // 尝试选择当前数字 candidates[curPos]，最多可以选 (target - curSum) / candidates[curPos] 次
        for (int i=0; i<=(target-curSum)/candidates[curPos]; i++) {
            for (int j=0; j<i; j++) {
                curRes.add(candidates[curPos]);
                curSum += candidates[curPos];
            }
            backTrack(candidates, target, curPos + 1, curSum, curRes);
            for (int j=0; j<i; j++) {
                curRes.remove(curRes.size() - 1);
                curSum -= candidates[curPos];
            }
        }
    }
}
