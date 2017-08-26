package com.company.contest46;

import apple.laf.JRSUIUtils;
import com.company.TreeNode;

import java.util.Stack;

/**
 * Created by sunbinqiang on 20/08/2017.
 */
public class Solution_2 {

    public boolean checkEqualTree(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (root != node) {
                int sum1 = dfsSum(root, node, 0);
                int sum2 = dfsSum(node, 0);
                if (sum1 == sum2) {
                    return true;
                }
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return false;
    }

    private int dfsSum(TreeNode root, TreeNode node, int sum) {
        if (root == null || root == node) {
            return 0;
        }
        sum = sum + root.val;
        if (root.left != node) {
            sum += dfsSum(root.left, 0);
        }
        if (root.right != node) {
            sum += dfsSum(root.right, 0);
        }
        return sum;
    }

    private int dfsSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum + root.val;
        sum += dfsSum(root.left, 0);
        sum += dfsSum(root.right, 0);
        return sum;
    }

    public static void test() {
        Solution_2 solution_2 = new Solution_2();
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(10);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;


        System.out.println(solution_2.checkEqualTree(treeNode));
    }


}
