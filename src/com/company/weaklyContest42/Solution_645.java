package com.company.weaklyContest42;

/**
 * Created by sunbinqiang on 23/07/2017.
 */
public class Solution_645 {
    public int[] findErrorNums(int[] nums) {
        int[] result = {0, 0};
        for (int i = 0; i < nums.length; i ++) {
            int value = nums[i];
            if (value == 0) {
                continue;
            }
            while (nums[value-1] != 0 && value -1 != i) {
                int temp = nums[value-1];
                nums[value-1] = 0;
                value = temp;
            }
            if (value-1 == i) {
                nums[i] = 0;
                continue;
            }
            if (result[0] == 0) {
                result[0] = value;
            }
        }
        for (int j = 0; j < nums.length; j ++) {
            if (nums[j] != 0) {
                result[1] = j + 1;
            }
        }
        return result;
    }

    public static void test() {
        Solution_645 solution_645 = new Solution_645();
        int[] nums = {1,5,3,2,2,7,6,4,8,9};
        int[] res = solution_645.findErrorNums(nums);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
