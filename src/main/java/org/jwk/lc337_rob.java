package org.jwk;

public class lc337_rob {
}

class Solution337 {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    int[] dfs(TreeNode node) { //返回一个数组，第0个表示取当前节点的最大值，第1个表示不取当前节点的最大值
        if (node == null)
            return new int[]{0, 0};
        if (node.left==null && node.right==null)
            return new int[]{node.val, 0};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int choose = node.val + left[1] + right[1]; //如果当前节点要取的话，只能是左右孩子都不取
        int notChoose = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{choose, notChoose};
    }
}