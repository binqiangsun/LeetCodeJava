package com.company.weaklyContest40;

import com.company.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbinqiang on 10/07/2017.
 * https://leetcode.com/problems/shopping-offers/#/description
 * 遍历每一个special list
 * 递归
 *
 */
public class Solution_638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        int result = Integer.MAX_VALUE;

        for (List<Integer> s : special) {
            int sCount = Integer.MAX_VALUE;
            //在不超量的情况下获取最大的优惠item数量
            for (int i = 0; i < needs.size(); i ++) {
                if (s.get(i) != 0) {
                    sCount = Math.min(needs.get(i) / s.get(i), sCount);
                }
            }

            if (sCount == Integer.MAX_VALUE || sCount == 0) {
                continue;
            }

            //更新needs
            for (int i = 0; i < needs.size(); i ++) {
                needs.set(i, needs.get(i) - s.get(i) * sCount);
            }

            //
            result = Math.min(result, s.get(s.size() - 1) * sCount + shoppingOffers(price, special, needs));

            //reset needs
            for (int i = 0; i < needs.size(); i ++) {
                needs.set(i, needs.get(i) + s.get(i) * sCount);
            }
        }

        int nonSpecialPrice = 0;
        for (int i = 0; i < needs.size(); i ++) {
            nonSpecialPrice += price.get(i) * needs.get(i);
        }

        return Math.min(result, nonSpecialPrice);
    }

    public static void test() {
        List<Integer> price = new ArrayList();
        List<Integer> s1 = new ArrayList<>();
        List<Integer> s2 = new ArrayList<>();
        List<List<Integer>> special = new ArrayList<>();
        List<Integer> needs = new ArrayList<>();
        price.add(2);
        price.add(5);
        s1.add(3); s1.add(0); s1.add(5);
        s2.add(1); s2.add(2); s2.add(10);
        special.add(s1);
        special.add(s2);
        needs.add(3); needs.add(2);

        Solution_638 solution_638 = new Solution_638();
        System.out.println(solution_638.shoppingOffers(price, special, needs));


    }
}
