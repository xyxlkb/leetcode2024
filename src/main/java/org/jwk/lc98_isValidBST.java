package org.jwk;

public class lc98_isValidBST {
    public static void main(String[] args) {
        Solution98 solution = new Solution98();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(solution.isValidBST(root));
    }
}

class Solution98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTHelper(TreeNode root, Long min, Long max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;

        return isValidBSTHelper(root.left, min, Math.min(max, root.val)) &&
                isValidBSTHelper(root.right, Math.max(min, root.val), max);
    }
}