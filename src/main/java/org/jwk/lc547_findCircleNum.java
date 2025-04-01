package org.jwk;

public class lc547_findCircleNum {
}

class Solution547 {
    boolean[] visited;

    public int findCircleNum(int[][] isConnected) {
        int cnt = 0;
        int n = isConnected.length;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) { //任何一个没访问过的城市，就进去搜索一遍，并且城市数++
                cnt++;
                dfs(isConnected, i);
            }
        }

        return cnt;
    }

    private void dfs(int[][] isConnected, int cur) {
        visited[cur] = true;
        int n = isConnected.length;
        for (int i=0; i<n; i++) {
            if (i!=cur && isConnected[cur][i]==1 && !visited[i])
                dfs(isConnected, i);
        }
    }
}