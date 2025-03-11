package org.jwk;

public class lc404_sumOfLeftLeaves {
}

class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        dfs(root, false);
        return sum;
    }
    // isLeft:目前这个节点是否左孩子
    private void dfs(TreeNode root, boolean isLeft) {
        if (root == null)
            return;
        if (root.left==null && root.right==null && isLeft) {
            sum+= root.val;
            return;
        }

        dfs(root.left, true);
        dfs(root.right, false);
    }
}