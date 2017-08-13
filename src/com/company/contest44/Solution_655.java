package com.company.contest44;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by sunbinqiang on 08/08/2017.
 */
public class Solution_655 {
    public List<List<String>> printTree(TreeNode root) {

        if (root == null) return null;

        List<List<String>> result = new ArrayList<>();
        Queue<TreeNode> queue = new PriorityQueue<>();
        queue.add(root);
        List<String> levelListRoot = new ArrayList<>();
        levelListRoot.add(String.valueOf(root.val));
        result.add(levelListRoot);

        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> levelList = new ArrayList<>();
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    queue.add(null);
                    levelList.add(String.valueOf(node.val));
                } else {
                    levelList.add("");
                }
            }
            result.add(levelList);
            index ++;
        }

        int width = (int)Math.pow(2, result.size()) - 1;
        int height = result.size();
        for (int i = 0; i < result.size(); i ++) {
            List<String> levelList = result.get(i);
            int originSize = levelList.size();
            for (int k = 0; k < originSize; k ++) {
                String temp = levelList.get(k);
                levelList.add(k, "");
                levelList.set(width / (int)Math.pow(2, 1+i) + k * (int)Math.pow(2, height - i), temp);
            }
            for (int j = 0; j < width; j ++) {
                if (levelList.get(j) == null) {
                    levelList.set(j, "");
                }
            }
        }
        return result;
    }
}
