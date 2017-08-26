package com.company.bfs;

import com.company.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sunbinqiang on 17/08/2017.
 * BFS
 * 每一层从右往左的遍历
 */
public class Solution_513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode last = root;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                last = queue.poll();
                if (last.right != null) {
                    queue.add(last.right);
                }
                if (last.left != null) {
                    queue.add(last.left);
                }
            }
        }
        return last.val;
    }

}
