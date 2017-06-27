package com.company;

/**
 * Created by sunbinqiang on 23/06/2017.
 * 两种解决方法：
 * 1， 遍历获取较小的值；
 * 2， 递归的方法
 */
public class MergeSortedList21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode pre ;
        if (l1.val < l2.val) {
            pre = l1;
            l1 = l1.next;
        } else {
            pre = l2;
            l2 = l2.next;
        }
        ListNode head = pre;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;

        return head;
    }

    public ListNode mergeLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeLists(l1, l2.next);
            return l2;
        }
    }


}
