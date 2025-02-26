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
//    private boolean[][] path;
    private List<List<Integer>> adjacencyList;
    private boolean[] visited;
    private boolean havecircle = false;
    private int n;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        n = numCourses;
        visited = new boolean[n];
//        path = new boolean[n][n];
//        initialisepath();
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjacencyList.add(new ArrayList<>());
        for (int[] i : prerequisites)
//                path[i[0]][i[1]] = true;
            adjacencyList.get(i[0]).add(i[1]);
        for (int i=0; i<n; i++){
            if(havecircle)
                return false;
//            initialisevisited(); //每次进入深度搜索前，先标记所有都没访问过 不用标记！因为每次返回的时候会取消访问标记
            dfs(i);
        }
        return !havecircle; //如果每一次深搜之后都没有环的话，就说明能上完课
    }

    public void dfs(int t) {
        if (havecircle) //如果已经检测到有环了，就不用任何操作直接返回
            return;
        if (visited[t]) { //如果t被访问过了，说明有环了
            havecircle = true;
            return;
        }
        visited[t] = true; //把当前点标记为访问过
        for(int i : adjacencyList.get(t)){ //深度搜索每一个t能到的点
//            if (path[t][i])
            dfs(i);
        }
        visited[t] = false; //这次深度搜索结束，去别的路径，又把当前点标记为没访问过，防止别的环串了
    }

//    private void initialisepath(){
//        for (int i=0; i<n; i++)
//            for (int j=0; j<n; j++)
//                path[i][j] = false;
//    }
//    private void initialisevisited(){
//        for (int i=0; i<n; i++)
//            visited[i] = false;
//    }
}