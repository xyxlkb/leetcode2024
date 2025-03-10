package org.jwk;

import java.util.HashMap;
import java.util.Map;

public class lc104_maxDepth {
}

class Solution104 {
    int max = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return max;
    }
    public void dfs(TreeNode root, int curDepth) {
        if (root == null)
            return;
        curDepth++;
        if (curDepth > max)
            max = curDepth;
        dfs(root.left, curDepth);
        dfs(root.right, curDepth);
    }
}
