package org.jwk;

import java.util.ArrayList;
import java.util.List;

public class lc144_preorderTraversal {
}

class Solution144 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root) {
        if (root == null)
            return;

        res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}