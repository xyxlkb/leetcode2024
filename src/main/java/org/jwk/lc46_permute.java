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
/*    //整体思路：按顺序拿每一个数字，第i个数字可以在前面i-1个数字的每一个排列中插入i个位置
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
    }*/

    List<List<Integer>> result = new ArrayList<>(); // 存储所有排列结果
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> curRes = new ArrayList<>(); // 当前排列
        boolean[] visited = new boolean[nums.length]; // 标记数组，记录哪些元素已被使用
        backtrack(nums, visited, curRes);
        return result;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> curRes) {
        // 如果当前排列的长度等于 nums 的长度，说明找到一个完整的排列
        if (curRes.size() == nums.length) {
            result.add(new ArrayList<>(curRes)); // 将当前排列加入结果集
            return;
        }

        // 遍历数组中的每一个元素
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue; // 如果当前元素已被使用，跳过
            }

            // 选择当前元素
            visited[i] = true; // 标记为已使用
            curRes.add(nums[i]); // 将当前元素加入排列

            // 递归处理下一层
            backtrack(nums, visited, curRes);

            // 撤销选择
            curRes.remove(curRes.size() - 1); // 移除当前元素
            visited[i] = false; // 取消标记
        }
    }
}