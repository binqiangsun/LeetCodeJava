package com.company.dfs;

import com.company.TreeNode;

/**
 * Created by sunbinqiang on 26/08/2017.
 */
public class Solution_101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return isEqual(root.left, root.right);

    }

    private boolean isEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return left.val == right.val && isEqual(left.left, right.right) && isEqual(left.right, right.left);
        }
        return false;
    }


}
