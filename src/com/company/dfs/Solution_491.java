package com.company.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sunbinqiang on 19/08/2017.
 */
public class Solution_491 {
    private Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {

        List<Integer> list = new ArrayList<>();
        getList(nums, 0, list);

        return new ArrayList<>(result);
    }

    private void getList(int[] nums, int level, List<Integer> list) {
        if (list.size() > 1) {
            result.add(new ArrayList<>(list));
            //list.clear();
        }
        if (nums.length == level) {
            return;
        }
        if (list.size() == 0 || (list.size() > 0 && nums[level] >= list.get(list.size() - 1))) {
            //可以增加， 也可以不增加
            list.add(nums[level]);
            getList(nums, level + 1, list);
            list.remove(list.size()-1);
            getList(nums, level + 1, list);
        } else {
            //不增加
            getList(nums, level + 1, list);
        }
    }

    public static void test() {
        Solution_491 solution_491 = new Solution_491();
        int[] nums = {4, 6, 7, 7};
        solution_491.findSubsequences(nums);
    }



}
