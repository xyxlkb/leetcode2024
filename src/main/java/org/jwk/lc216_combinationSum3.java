package org.jwk;

import java.util.ArrayList;
import java.util.List;

public class lc216_combinationSum3 {
}

class Solution216 {
    List<List<Integer>> res;

    //从1～9中选k个数字，让他们的和为n，把所有可能方法返回
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        backTrack(k, n, 1, new ArrayList<>());
        return res;
    }

    // curNum：目前回溯到哪个数字了；curRes：目前的结果集
    private void backTrack(int k, int n, int curNum, List<Integer> curRes) {
        if (curRes.size() == k) {
            int sum = 0;
            for (Integer num : curRes)
                sum += num;
            if (sum == n)
                res.add(new ArrayList<>(curRes));
            return;
        }
        if (curNum > 9)
            return;

        curRes.add(curNum);
        backTrack(k, n, curNum + 1, curRes);
        curRes.remove(curRes.size() - 1);
        backTrack(k, n, curNum + 1, curRes);
    }
}