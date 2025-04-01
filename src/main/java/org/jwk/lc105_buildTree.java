package org.jwk;

import java.util.HashMap;
import java.util.Map;

public class lc105_buildTree {
    public static void main(String[] args) {
        Solution105 solution = new Solution105();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = solution.buildTree(preorder, inorder);
    }
}
class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 用来记录每一个节点在数组的哪里，可以快速找到节点
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i],i);
        }

        return buildTreeHelper(preorder, 0, preorder.length-1,
                                inorder, 0, inorder.length-1, inMap);

    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                     int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootPos = inMap.get(root.val); //在inorder中root的位置
        int leftLength = rootPos - inStart; //左子树的长度

        root.left = buildTreeHelper(preorder, preStart+1, preStart+leftLength,
                                    inorder, inStart, rootPos-1, inMap);

        root.right = buildTreeHelper(preorder, preStart+leftLength+1, preEnd,
                                    inorder, rootPos+1, inEnd, inMap);

        return root;
    }


}
