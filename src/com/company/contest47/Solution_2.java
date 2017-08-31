package com.company.contest47;

import com.company.ListNode;
import com.company.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sunbinqiang on 27/08/2017.
 */
public class Solution_2 {
    private int total;
    public int pathSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        dfsSum(getTreeNode(nums), 0);
        return total;
    }


    private TreeNode getTreeNode(int[] nums) {
        List<LinkedList<TreeNode>> lists = new ArrayList<>();
        int level = 0;
        int index = 0;
        int val = 0;
        for (int i = 0; i < nums.length; i ++) {
            int num = nums[i];
            val = num % 10;
            num = num / 10;
            index = num % 10;
            num = num / 10;
            level = num;
            //
            LinkedList<TreeNode> levelList;
            if (level > lists.size()) {
                levelList = new LinkedList<>(Arrays.asList(new TreeNode[10]));
                lists.add(levelList);
            } else {
                levelList = lists.get(level - 1);
            }
            TreeNode newNode = new TreeNode(val);
            levelList.add(index, newNode);
            if (level > 1) {
                if (index % 2 == 0) {
                    lists.get(level-2).get(index / 2).right = newNode;
                } else {
                    lists.get(level-2).get((index+1) / 2).left = newNode;
                }
            }
        }
        return lists.get(0).get(1);
    }


    private void dfsSum(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        sum += node.val;
        if (node.left == null && node.right == null) {
            total += sum;
            return;
        }
        dfsSum(node.left, sum);
        dfsSum(node.right, sum);
    }

    public static void test() {
        Solution_2 solution_2 = new Solution_2();
        int[] nums = {113,215,221};
        System.out.println(solution_2.pathSum(nums));
    }
}
