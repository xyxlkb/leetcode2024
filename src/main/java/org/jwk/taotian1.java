package org.jwk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// * 输入：[1,4] [2,5] [8,9] 输出：[6,7]
// * 输入：[-2,3] [1,4] [8,9] 输出：[5,7]
// * 输入：[8,9] [2,3] [1,4] [6,9] 输出：[5,5]
// * 输入：[1,4] [12,14] [2,5] [8,9] 输出：[6,7] [10,11]
// * 输入：[1,4] [2,5] 输出：[]

public class taotian1 {
    public static void main(String[] args) {
        int[][] test1 = {{1,4}, {2,5}, {8,9}};
        System.out.println(Arrays.deepToString(findMissingInterval(test1)));

        int[][] test2 = {{-2,3}, {1,4}, {8,9}};
        System.out.println(Arrays.deepToString(findMissingInterval(test2)));

        int[][] test3 = {{8,9}, {2,3}, {1,4}, {6,9}};
        System.out.println(Arrays.deepToString(findMissingInterval(test3)));

        int[][] test4 = {{1,4}, {12,14}, {2,5}, {8,9}};
        System.out.println(Arrays.deepToString(findMissingInterval(test4)));

        int[][] test5 = {{1,4}, {2,5}};
        System.out.println(Arrays.deepToString(findMissingInterval(test5)));

        int[][] test6 = {{1,4}};
        System.out.println(Arrays.deepToString(findMissingInterval(test6)));

    }

    public static int[][] findMissingInterval(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1)
            return new int[0][];

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); // 按起点排序
        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty()) {
                merged.add(interval);
            } else {
                int[] last = merged.get(merged.size() - 1);
                if (interval[0] <= last[1]) {
                    last[1] = Math.max(last[1], interval[1]);
                } else {
                    merged.add(interval);
                }
            }
        }

        List<int[]> gaps = findGaps(merged);

        return gaps.toArray(new int[gaps.size()][]);
    }

    private static List<int[]> findGaps(List<int[]> merged) {
        List<int[]> gaps = new ArrayList<>();
        for (int i=1; i<merged.size(); i++) {
            int[] prev = merged.get(i-1);
            int[] curr = merged.get(i);
            int gapStart = prev[1] + 1;
            int gapEnd = curr[0] - 1;
            if (gapEnd >= gapStart)
                gaps.add(new int[]{gapStart, gapEnd});
        }
        return gaps;
    }

}
