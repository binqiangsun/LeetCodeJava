package com.company;

/**
 * Created by sunbinqiang on 21/06/2017.
 */
public class FlattenBinaryTreeToLinkedList114 {

    public void flatten(TreeNode root) {

        if (root == null) return;
        flatten(root.left);
        flatten(root.right);

        TreeNode flattenLeft = root.left;
        TreeNode flattenRight = root.right;

        root.right = flattenLeft;
        root.left = null;

        while (root.right != null) {
            root = root.right;
        }
        root.right = flattenRight;

    }

    private TreeNode flattenNode(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode flattenLeft = flattenNode(root.left);
        TreeNode flattenRight = flattenNode(root.right);
        TreeNode flattenLefeEnd = getEndNode(flattenLeft);
        root.left = null;
        root.right = flattenLeft;
        if (flattenLefeEnd != null) {
            flattenLefeEnd.right = flattenRight;
        } else {
            root.right = flattenRight;
        }
        return root;
    }

    private TreeNode getEndNode(TreeNode root) {
        if (root == null || root.right == null) return root;
        return getEndNode(root.right);
    }

//    private TreeNode preOrder(TreeNode root) {
//        if (root == null) return null;
//
//        preOrder(root.left);
//        preOrder(root.right);
//    }


    //     * Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
