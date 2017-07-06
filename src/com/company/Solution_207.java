package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sunbinqiang on 01/07/2017.
 * @link https://leetcode.com/problems/course-schedule/#/description
 * 选课问题: 课程总数numCourses, 课程有前置条件， 如果前置条件互相依赖，则不合理，返回false

 * 有向图找环的问题
 *
 * 1， 找出所有节点中入度为0的节点， 入栈； 这些课程是没有任何依赖的课程
 * 2， 循环（以栈为空跳出循环）； 删除该节点的边，如果与该节点关联的节点入度为0的话入栈；
 * 3， 如果图中还有元素， 则有环
 *
 * 问题： 矩阵结构， 效率很低

 */
public class Solution_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] map = new int[numCourses][numCourses];

        //初始化map
        for (int[] prerequisite : prerequisites) {
            map[prerequisite[0]][prerequisite[1]] = 1;
        }

        //
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < numCourses; i ++) {
            pushStask(i, map, numCourses, stack);
        }

        while (!stack.isEmpty()) {
            int k = stack.pop();
            for (int i = 0; i < numCourses; i ++) {
                if (map[k][i] == 1) {
                    map[k][i] = 0;
                    pushStask(i, map, numCourses, stack);
                }
            }
        }

        return isMapEmpty(map, numCourses);

    }

    private boolean isMapEmpty(int[][] map, int num) {
        for (int i = 0; i < num; i ++) {
            for (int j = 0; j < num; j ++) {
                if (map[i][j] > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void pushStask(int i, int[][] map, int numCourses, Stack<Integer> stack) {
        int enter = 0, out = 0;
        for (int j = 0; j < numCourses; j ++) {
            if (map[j][i] > 0) {
                enter ++;
                break;
            }
        }
        for (int k = 0; k < numCourses; k ++) {
            if (map[i][k] > 0) {
                out ++;
                break;
            }
        }
        if (enter == 0 && out > 0) {
            stack.push(i);
        }
    }


    //该算法不对
    private boolean bfsMap(int first, int[][] map, int length) {
        //标记是否访问过
        int[] visited = new int[length];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(first);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                int j = queue.remove();
                if (visited[j] == 1) {
                    return false;
                }
                visited[j] = 1;

                //遍历j关联的节点
                for (int k = 0; k < length; k ++) {
                    if (map[j][k] == 1) {
                        queue.add(k);
                    }
                }
            }
        }
        return true;
    }


    public static void test() {
        Solution_207 solution_207 = new Solution_207();
        int[][] prerequires = {{0, 1}, {0, 2}};
        System.out.println("207=----------------------------------------------");
        System.out.println(solution_207.canFinish(3, prerequires));
        System.out.println("207=----------------------------------------------");
    }
}
