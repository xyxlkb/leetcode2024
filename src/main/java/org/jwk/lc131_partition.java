package org.jwk;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class lc131_partition {
    public static void main(String[] args) {
        Solution131 solution131 = new Solution131();
        List<List<String>> res = solution131.partition("ababa");
        for (int i=0; i<res.size(); i++)
            System.out.println(res.get(i));
    }
}

class Solution131 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTrack(s, 0, new ArrayList<>());
        return res;
    }

    public void backTrack(String s, int left, List<String> curRes) {
        if (left == s.length()) {
            res.add(new ArrayList<>(curRes));
            return;
        }

        for (int right=left; right<s.length(); right++) {
            if (isHuiWen(s, left, right)) { //把从left开始的所有可能的回文串都试一次，加入结果
                curRes.add(s.substring(left, right+1));
                backTrack(s, right+1, curRes);
                curRes.remove(curRes.size()-1); //把最后一个删掉，恢复现场
            }
        }
    }

    private boolean isHuiWen(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}

/*class Solution131 {
    boolean[] used; //用于回溯，是否被使用过
    int[] midLen; //表示以i为中心，往两边延申多长是回文串
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        int n = s.length();
        used = new boolean[n];
        for (int i=0; i<n; i++)
            used[i] = false;
        midLen = new int[n];

        for (int i=0; i<n; i++) {
            int curLen = 0;
            for (int j=1; j<=n/2; j++) {
                if (i-j<0 || i+j>=n)
                    continue;
                if (s.charAt(i-j) == s.charAt(i+j))
                    curLen++;
                else
                    break;
            }
            midLen[i] = curLen;
        }

        List<String> curRes = new ArrayList<>();
        backTrack(s, 0, curRes);

        return res;
    }

    public void backTrack(String s, int curPos, List<String> curRes) {
        if (curPos == s.length()) {
            for (int i=0; i<s.length(); i++) //如果有一个没被使用过，说明不完整
                if (!used[i])
                    return;
//            System.out.println("Current Position: " + curPos + ", Current Result: " + curRes);
            res.add(new ArrayList<>(curRes));
            return;
        }

        int left = curPos;
        int right = curPos;
        for (int i=1; i<=midLen[curPos]; i++) { //从当前位置向两边发散，看能形成多长的回文串
            left = curPos - i;
            right = curPos + i;
            if (used[left] || used[right]) {
                left++;
                right--;
                break;
            }
        }

        for (int i=left; i<=right; i++) {
            used[i] = true;
        }
        curRes.add(s.substring(left, right+1));
        backTrack(s, right+1, curRes);
        for (int i=left; i<=right; i++) {
            used[i] = false;
        }
        curRes.remove(curRes.size()-1); //把最后一个删掉，恢复现场
        backTrack(s, curPos+1, curRes);
    }
}*/
