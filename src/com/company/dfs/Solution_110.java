package com.company.dfs;

import com.company.TreeNode;

/**
 * Created by sunbinqiang on 26/08/2017.
 */
public class Solution_110 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (leftHeight - rightHeight < -1 || leftHeight - rightHeight > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
