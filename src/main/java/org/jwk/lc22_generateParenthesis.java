package org.jwk;

import java.util.ArrayList;
import java.util.List;

public class lc22_generateParenthesis {
    public static void main(String[] args) {
        Solution22 solution = new Solution22();
        System.out.println(solution.generateParenthesis(3));
    }
}

class Solution22 {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backTrack(0, 0, "", n);
        return ans;
    }

    private void backTrack(int leftCount, int rightCount, String curAns, int n) {
//        System.out.println("curans: "+ curAns);
        if (leftCount>n || rightCount>n) {
            return;
        } else if (rightCount==n && leftCount==n) {
            ans.add(curAns);
            return;
        } else if (leftCount<rightCount) {
            return;
        } else if (leftCount==rightCount) {
            curAns = curAns + "(";
            backTrack(leftCount+1, rightCount, curAns, n);
        } else {
            curAns = curAns + "(";
            backTrack(leftCount+1, rightCount, curAns, n);
            curAns = curAns.substring(0, curAns.length()-1);

            curAns = curAns + ")";
            backTrack(leftCount, rightCount+1, curAns, n);
        }
    }
}