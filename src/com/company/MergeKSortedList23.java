package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by sunbinqiang on 26/06/2017.
 * PriorityQueue  小根堆算法， 获取最小值 时间复杂度为 O(N*K*LogK)
 *
 * 归并算法
 *
 */
public class MergeKSortedList23 {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });


        ListNode head = new ListNode(0);
        ListNode res = head;

        for (ListNode listNode : lists) {
            if (listNode != null) {
                priorityQueue.add(listNode);
            }
        }

        while (priorityQueue.size() != 0) {
            ListNode minNode = priorityQueue.poll();
            head.next = minNode;
            head = minNode;
            if (minNode.next != null) {
                priorityQueue.add(minNode.next);
            }
        }

        return res.next;

    }


//        ListNode minNode = getMinNode(lists);
//        if (minNode == null) {
//            return null;
//        }
//        minNode.next = mergeKLists(lists);
//        return minNode;

    /** 这种方式获取min，时间复杂度为O（N）， 整体复杂度为N*K*K
     * @param lists
     * @return
     */
    private ListNode getMinNode(ListNode[] lists) {
        ListNode res = null;
        int minVal = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < lists.length; i ++) {
            ListNode listNode = lists[i];
            if (listNode != null && listNode.val <= minVal) {
                res = listNode;
                minVal = res.val;
                index = i;
            }
        }
        if (minVal != Integer.MAX_VALUE) {
            lists[index] = lists[index].next;
        }
        return res;
    }





}
