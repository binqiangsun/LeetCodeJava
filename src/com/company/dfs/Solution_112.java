package com.company.dfs;

import com.company.TreeNode;

/**
 * Created by sunbinqiang on 26/08/2017.
 */
public class Solution_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return pathSum(root, 0, sum);
    }

    private boolean pathSum(TreeNode node, int currentSum, int sum) {
        if (node == null) {
            return false;
        }
        currentSum += node.val;
        if (node.left == null && node.right == null) {
            return currentSum == sum;
        }
        return pathSum(node.left, currentSum, sum) || pathSum(node.right, currentSum, sum);
    }
}
