package com.company.weaklyContest43;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbinqiang on 30/07/2017.
 */
public class Solution_652 {
    private List<TreeNode> duplicate = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) return result;
        preOrder1(result, root, root);
        return result;
    }

    private void preOrder1(List<TreeNode> result, TreeNode root, TreeNode currentNode) {
        if (currentNode == null || root == null) {
            return;
        }
        preOrder(result, root, currentNode);


        preOrder1(result, root, currentNode.left);
        preOrder1(result, root, currentNode.right);
    }

    private void preOrder(List<TreeNode> result, TreeNode root, TreeNode currentNode) {
        if (currentNode == null || root == null) {
            return;
        }
        if (!duplicate.contains(currentNode) &&
                isDuplicate(root, currentNode, 0)) {
            if (!result.contains(currentNode)) {
                result.add(currentNode);
            }
        }
        preOrder(result, root.left, currentNode);
        preOrder(result, root.right, currentNode);
    }

    private boolean isDuplicate(TreeNode root, TreeNode curNode, int level) {
        if (root == null && curNode == null) {
            return true;
        }
        if (root == curNode) {
            return false;
        }
        if (root == null || curNode == null) {
            return false;
        }
        if (root.val == curNode.val) {
            boolean isChild = isDuplicate(root.left, curNode.left, level+1) && isDuplicate(root.right, curNode.right, level+1);
            if (isChild && level == 0) {
                duplicate.add(root);
            }
            return isChild;
        } else {
            return false;
        }
    }

    public static void test() {
        Solution_652 solution_652 = new Solution_652();
        TreeNode treeNode1 = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(0);
        TreeNode treeNode3 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(0);
        TreeNode treeNode5 = new TreeNode(0);
        TreeNode treeNode6 = new TreeNode(0);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;
        List<TreeNode> result = solution_652.findDuplicateSubtrees(treeNode1);
        System.out.println(result.size());
    }
}
