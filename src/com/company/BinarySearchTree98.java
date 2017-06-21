package com.company;

/**
 * Created by sunbinqiang on 14/06/2017.
 */
public class BinarySearchTree98 {


    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
//        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        if (root == null) return true;

        if (!isValidBST(root.left)) return false;

        if (root.val <= pre) return false;
        pre = root.val;

        return isValidBST(root.right);
    }

    private boolean isBST(TreeNode root, long min, long max) {
        return root == null || (root.val > min && root.val < max &&
                isBST(root.left, min, root.val) && isBST(root.right, root.val, max));
    }


    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
