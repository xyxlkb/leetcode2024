package org.jwk;

import java.util.*;

public class lc40_combinationSum2 {
    public static void main(String[] args) {
        Solution40 solution = new Solution40();
        System.out.println(solution.combinationSum2(new int[]{2,5,2,1,2}, 5));
    }
}

class Solution40 {
    List<List<Integer>> res = new ArrayList<>();
    int[] Candidates; //就不用每次递归都传了

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); //从小到大排序
        Candidates = candidates;
        backTrack(target, 0, new ArrayList<>());
        return res;
    }

    // remain表示还需要多少才能到达目标数字
    private void backTrack(int remain, int start, List<Integer> curRes) {
        if (remain == 0) {
            res.add(new ArrayList<>(curRes));
            return;
        }

        // 相当于是每次回溯取一个数字，但是这个数字可能是从start开始的每一个，所以循环要取的这个数字
        // 后面回溯的start就是目前取到的数字i。这样可以保证不重复，而且每个都从小到大取
        for (int i=start; i<Candidates.length; i++) {
            if (Candidates[i] > remain) // 剪枝：当前元素已超过剩余值
                break;
            // 去重：如果当前元素和前一个相同，且前一个没有被取，这个就不用取了
            // 因为每次start不同，所以第一次碰到一个数字的时候，是会取用的，所以比如取多个2，也是会出现的
            if (i>start && Candidates[i]==Candidates[i-1])
                continue;

            curRes.add(Candidates[i]);
            backTrack(remain-Candidates[i], i+1, curRes);
            curRes.remove(curRes.size()-1);
        }
    }
}