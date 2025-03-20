package org.jwk;

public class lc101_isSymmetric {
}

class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;

        return summetricDfs(root.left, root.right);
    }

    public boolean summetricDfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return summetricDfs(left.left, right.right) && summetricDfs(left.right, right.left);
    }
}