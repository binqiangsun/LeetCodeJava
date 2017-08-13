package com.company.contest44;

import com.company.TreeNode;

/**
 * Created by sunbinqiang on 08/08/2017.
 */
public class Solution_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return findMaxNode(nums, 0, nums.length-1);
    }

    private TreeNode findMaxNode(int[] nums, int start, int end) {
        int maxIndex = findMaxIndex(nums, start, end);
        if (maxIndex == -1) {
            return null;
        }
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = findMaxNode(nums, start, maxIndex - 1);
        node.right = findMaxNode(nums, maxIndex + 1, end);

        return node;
    }

    private int findMaxIndex(int[] nums, int start, int end) {
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i ++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        return index;
    }


}
