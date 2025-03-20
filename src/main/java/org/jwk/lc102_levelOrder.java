package org.jwk;

import com.fasterxml.jackson.databind.util.NativeImageUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc102_levelOrder {
}

class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); //当前队列内节点数，就是当前层的节点数
            List<Integer> curLevel = new ArrayList<>(); //记录当前层的所有数字
            for (int i=0; i<levelSize; i++) {
                curLevel.add(queue.peek().val); //记录当前节点的数字，把他左右孩子放进队列
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                queue.poll();
            }
            res.add(curLevel);
        }
        return res;
    }
}