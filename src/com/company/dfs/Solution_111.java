package com.company.dfs;

import com.company.TreeNode;

/**
 * Created by sunbinqiang on 26/08/2017.
 */
public class Solution_111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return minDfsDepth(root, 1);
    }

    private int minDfsDepth(TreeNode root, int level) {
        if (root.left == null && root.right == null) {
            return level;
        }
        if (root.left == null) {
            return minDfsDepth(root.right, level + 1);
        }
        if (root.right == null) {
            return minDfsDepth(root.left, level + 1);
        }
        return Math.min(minDfsDepth(root.left, level + 1), minDfsDepth(root.right, level + 1));
    }
}
