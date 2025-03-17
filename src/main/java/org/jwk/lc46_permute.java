package org.jwk;

import java.util.ArrayList;
import java.util.List;

public class lc46_permute {
    public static void main(String[] args) {
        Solution46 solution = new Solution46();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }
}

class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        t.add(nums[0]);
        result.add(t);

        for (int i = 1; i < nums.length; i++) { //在nums中取第i个数字加入
            int n = result.size(); //在循环内会修改result的长度，所以先记录下来，不然会死循环了！
            for (int k=0; k<n; k++) {
                List<Integer> curRes = result.get(k);
                for (int j=0; j<i; j++) { //第i个数字可以放在从0到i的位置上，在每一个已有的组合里
                    List<Integer> temp = new ArrayList<>(curRes);
                    temp.add(j, nums[i]);
                    result.add(temp);
                }
                result.get(k).add(nums[i]);
            }
        }
        return result;
    }
}