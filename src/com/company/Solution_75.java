package com.company;

/**
 * Created by sunbinqiang on 21/06/2017.
 * 3种颜色排序
 * 1， 交换方法， 最小的交换到最左边， 最大的交换到最右边
 * 2， 以颜色值0， 1， 2作为index，用数组（或者hashmap）记录出现的次数， 然后再生成数组；
 */
public class Solution_75 {
    public void sortColors(int[] nums) {

        int[] colorCount = {0, 0, 0};
        for (int num : nums) {
            colorCount[num]++;
        }
        int j = 0, k = 0;
        for (int count : colorCount) {
            while (count-- > 0) {
                nums[j++] = k;
            }
            k ++;
        }

    }

    public void sortColors2(int[] nums) {

        int i = 1, head = 0, tail = nums.length - 1;

        while (i < tail) {
            if (nums[i] == 0) {
                nums[i] = nums[head];
                nums[head] = 0;
            } else if (nums[i] == 2) {
                nums[i] = nums[tail];
                nums[tail] = 2;
                tail --;
            } else {
                i ++;
                if (nums[head] == 0) {
                    head ++;
                }
                if (nums[tail] == 2) {
                    tail --;
                }
            }
        }
    }
}
