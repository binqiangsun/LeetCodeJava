package com.company;

/**
 * Created by sunbinqiang on 16/06/2017.
 * 任意二叉树 寻找最近的公共祖先
 */
public class Solution_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if (root == p || root == q) return root;

        TreeNode leftAc = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAc = lowestCommonAncestor(root.right, p, q);

        if (leftAc != null && rightAc != null) return root;

        return leftAc == null ? rightAc : leftAc;
    }
}
