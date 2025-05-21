package org.jwk;

public class lc200_numIslands {
}

class Solution200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0; // 如果网格为空，直接返回0
        }

        int rows = grid.length; // 网格的行数
        int cols = grid[0].length; // 网格的列数
        int islandCount = 0; // 用于记录岛屿的数量

        // 遍历整个网格
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果当前位置是陆地（'1'），则发现了一个新的岛屿
                if (grid[i][j] == '1') {
                    islandCount++; // 岛屿数量加1
                    dfs(grid, i, j); // 从当前位置开始深度优先搜索，将整个岛屿标记为已访问
                }
            }
        }

        return islandCount; // 返回岛屿的总数
    }

    // 深度优先搜索方法
    private void dfs(char[][] grid, int row, int col) {
        // 检查边界条件，如果超出网格范围或当前位置是水（'0'），直接返回
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        // 将当前位置标记为已访问（即将其改为'0'）
        grid[row][col] = '0';

        // 递归访问当前位置的上下左右四个方向
        dfs(grid, row + 1, col); // 下
        dfs(grid, row - 1, col); // 上
        dfs(grid, row, col + 1); // 右
        dfs(grid, row, col - 1); // 左
    }


}