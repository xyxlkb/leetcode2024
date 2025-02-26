package org.jwk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc77_combine {
    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();
        System.out.println(solution77.combine(4,2).toString());
    }
}

class Solution77 {
    List<List<Integer>> result = new ArrayList<>(); //记录结果
    LinkedList<Integer> path = new LinkedList<>(); //记录路径

    public void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i); //选中i，加入路径
            backtracking(n, k, i + 1);
            path.removeLast(); //把i取出来，恢复现场
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }
}