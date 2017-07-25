package com.company.heap;

/**
 * Created by sunbinqiang on 22/07/2017.
 */
public class MyHeap {
    /**
     * 建立堆（大根堆）
     * @param nums
     * @param end  建立【0， end】长度的堆
     */
    public static void buildHeap(int[] nums, int end) {
        int start = (end % 2 == 0) ? (end / 2 - 1) : (end / 2);
        for (int i = start; i >= 0; i --) {
            int leafRight = i * 2 + 2;
            int leafLeft = i * 2 + 1;
            int numRight = leafRight > end ? Integer.MIN_VALUE : nums[leafRight];
            int numLeft = leafLeft > end ? Integer.MIN_VALUE : nums[leafLeft];
            //如果叶子节点大于父节点， 则交换
            if (numRight > numLeft && numRight > nums[i]) {
                nums[leafRight] = nums[i];
                nums[i] = numRight;
            } else if (numLeft > numRight && numLeft > nums[i]) {
                nums[leafLeft] = nums[i];
                nums[i] = numLeft;
            }
        }
    }

    public static void buildMinHeap(int[] nums, int end) {
        int start = (end % 2 == 0) ? (end / 2 - 1) : (end / 2);
        for (int i = start; i >= 0; i --) {
            int leafRight = i * 2 + 2;
            int leafLeft = i * 2 + 1;
            int numRight = leafRight > end ? Integer.MAX_VALUE : nums[leafRight];
            int numLeft = leafLeft > end ? Integer.MAX_VALUE : nums[leafLeft];
            //如果叶子节点大于父节点， 则交换
            if (numRight < numLeft && numRight < nums[i]) {
                nums[leafRight] = nums[i];
                nums[i] = numRight;
            } else if (numLeft < numRight && numLeft < nums[i]) {
                nums[leafLeft] = nums[i];
                nums[i] = numLeft;
            }
        }
    }
}
