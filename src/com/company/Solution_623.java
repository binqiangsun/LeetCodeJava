package com.company;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sunbinqiang on 18/06/2017.
 * 二叉树在指定深度增加一行
 */
public class Solution_623 {
    // Definition for a binary tree node.
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        Queue<TreeNode> pres = getNodeByDepth(root, d - 1);
        if (pres == null || pres.isEmpty()) {
            TreeNode newLeft = new TreeNode(v);
            newLeft.left = root;
            return newLeft;
        } else {
            TreeNode pre;
            while (pres.size() != 0) {
                pre = pres.remove();
                TreeNode newLeft = new TreeNode(v);
                TreeNode newRight = new TreeNode(v);
                TreeNode oldLeft = pre.left;
                TreeNode oldRight = pre.right;
                pre.left = newLeft;
                pre.right = newRight;
                newLeft.left = oldLeft;
                newRight.right = oldRight;
            }
            return root;
        }
    }


    private Queue<TreeNode> getNodeByDepth(TreeNode root, int d) {
        if (root == null || d <= 0) return null;
        int depth = 1;
        Queue<TreeNode> queueNodes = new LinkedList<>();
        queueNodes.add(root);
        while (!queueNodes.isEmpty()) {
            if (depth == d) {
                break;
            }
            int size = queueNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queueNodes.remove();
                if (node.left != null) {
                    queueNodes.add(node.left);
                }
                if (node.right != null) {
                    queueNodes.add(node.right);
                }
            }
            depth ++;
        }
        return queueNodes;
    }

}
