package com.company.dfs;

import com.company.TreeNode;

/**
 * Created by sunbinqiang on 26/08/2017.
 */
public class Solution_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return p == null && q == null;
    }
}
