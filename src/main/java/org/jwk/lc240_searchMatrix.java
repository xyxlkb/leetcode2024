package org.jwk;

public class lc240_searchMatrix {
}

class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int curRow = 0, curCol = m-1; //每行从右往左搜索
        while (curRow < n && curCol >= 0) {
            if (matrix[curRow][curCol] == target) {
                return true;
            } else if (matrix[curRow][curCol] < target) {
                curRow++;
            } else {
                curCol--;
            }
        }
/*        for (int i = 0; i < n; i++) {
            int left = 0, right = m-1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (matrix[i][mid] == target)
                    return true;
                else if (matrix[i][mid] < target)
                    left = mid + 1;
                else right = mid-1;
            }
        }*/

        return false;
    }
}