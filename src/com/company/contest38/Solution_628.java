package com.company.contest38;

import com.company.heap.MyHeap;

import java.util.PriorityQueue;

/**
 * Created by sunbinqiang on 22/07/2017.
 */
public class Solution_628 {
    public int maximumProduct(int[] nums) {
        int result = 1;
        int maxResult = Integer.MIN_VALUE;
        //3个值都为正数的情况
        for (int i = 0; i < 3; i ++) {
            buildHeap(nums, nums.length - 1 - i);
            int temp = nums[0];
            nums[0] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
            result *= temp;
            //
            if (i == 0) {
                maxResult = temp;
            }
        }
        int result2 = 1;
        //1个值为正数， 两个值为负数
        for (int i = 0; i < 2; i ++) {
            buildMinHeap(nums, nums.length - 1 - i);
            if (nums[0] >= 0) {
                return result;
            }
            int temp = nums[0];
            nums[0] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
            result2 *= temp;
        }
        result2 = result2 * maxResult;


        return result > result2 ? result : result2;
    }

    public void buildHeap(int[] nums, int end) {
        int start = (end % 2 == 0) ? (end / 2 - 1) : (end / 2);
        for (int i = start; i >= 0; i --) {
            int leafRight = i * 2 + 2;
            int leafLeft = i * 2 + 1;
            int numRight = leafRight > end ? Integer.MIN_VALUE : nums[leafRight];
            int numLeft = leafLeft > end ? Integer.MIN_VALUE : nums[leafLeft];
            //如果叶子节点大于父节点， 则交换
            if (numRight >= numLeft && numRight > nums[i]) {
                nums[leafRight] = nums[i];
                nums[i] = numRight;
            } else if (numLeft > numRight && numLeft > nums[i]) {
                nums[leafLeft] = nums[i];
                nums[i] = numLeft;
            }
        }
    }

    public void buildMinHeap(int[] nums, int end) {
        int start = (end % 2 == 0) ? (end / 2 - 1) : (end / 2);
        for (int i = start; i >= 0; i --) {
            int leafRight = i * 2 + 2;
            int leafLeft = i * 2 + 1;
            int numRight = leafRight > end ? Integer.MAX_VALUE : nums[leafRight];
            int numLeft = leafLeft > end ? Integer.MAX_VALUE : nums[leafLeft];
            //如果叶子节点大于父节点， 则交换
            if (numRight <= numLeft && numRight < nums[i]) {
                nums[leafRight] = nums[i];
                nums[i] = numRight;
            } else if (numLeft < numRight && numLeft < nums[i]) {
                nums[leafLeft] = nums[i];
                nums[i] = numLeft;
            }
        }
    }

    public static void test() {
        Solution_628 solution_628 = new Solution_628();
        int[] nums = {1, 1, 2, 2};
        System.out.println(solution_628.maximumProduct(nums));
    }
}
