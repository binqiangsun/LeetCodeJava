package com.company.contest44;

import com.company.TreeNode;

/**
 * Created by sunbinqiang on 08/08/2017.
 */
public class Solution_653 {
    public boolean findTarget(TreeNode root, int k) {
        return dfs1(root, root, k);
    }

    private boolean dfs1(TreeNode current, TreeNode root, int sum) {
        if (root == null || current == null) {
            return false;
        }
        if (!dfs2(root, current, sum - current.val)) {
            return dfs1(current.left, root, sum) || dfs1(current.right, root, sum);
        }
        return true;
    }

    private boolean dfs2(TreeNode root, TreeNode current, int i) {
        if (root == null || root == current) {
            return false;
        }
        if (root.val > i) {
            return dfs2(root.left, current, i);
        } else if (root.val < i) {
            return dfs2(root.right, current, i);
        }
        return true;
    }
}
