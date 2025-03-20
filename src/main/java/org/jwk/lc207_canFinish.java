package org.jwk;

import java.util.ArrayList;
import java.util.List;

public class lc207_canFinish {
    public static void main(String[] args) {
        Solution207 solution = new Solution207();
        int numCourses = 4;
        int[][] rerequisites = {
                {0,1},
                {3,1},
                {1,3},
                {3,2}
        };
//        System.out.println(rerequisites.length);
        System.out.println(solution.canFinish(numCourses, rerequisites));
    }
}

class Solution207 {
    List<List<Integer>> edges = new ArrayList<>();
    int[] visited; //0：未访问  1：访问中 2：已访问
    // 需要3种状态是为了避免重复访问，如果只有 2 种状态，无法区分一个节点是 正在访问 还是 已经访问完毕，从而导致误判。
    // 因为后面访问的节点再到前面访问过的节点，也很正常
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<>());
        }
        // 每一个点都对应一个list，代表他能到达的所有点
        for (int[] info : prerequisites) { //从1到0有一条路径（学习0之前必须先学习1）
            edges.get(info[1]).add(info[0]);
        }
        visited = new int[numCourses];

        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v: edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}