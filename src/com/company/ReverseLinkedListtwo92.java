package com.company;


/**
 * Created by sunbinqiang on 08/06/2017.
 */
public class ReverseLinkedListtwo92 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode res = reverse(next);
        head.next = null;
        next.next = head;
        return res;
    }

    private ListNode reverseRec(ListNode pre, ListNode node) {
        if (node.next == null) {
            node.next = pre;
            return node;
        }
        ListNode node1 = node.next;
        node.next = pre;
        return reverseRec(node, node1);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 1;
        ListNode res = head;
        ListNode preStart = null, start = null, end = null, nextEnd = null;
        while (head != null) {
            if (i == m - 1) {
                preStart = head;
            } else if (i == m) {
                start = head;
            }
            if (i == n) {
                end = head;
            } else if (i == n + 1) {
                nextEnd = head;
            }
            head = head.next;
            i++;
        }
        reverse(start, end);
        if (preStart != null) {
            preStart.next = end;
        } else {
            res = end;
        }
        start.next = nextEnd;

        return res;
    }

    private void reverse(ListNode start, ListNode end) {
        if (start == end) return;
        ListNode prtStart = start;
        ListNode ptrNext = start.next;
        while (ptrNext != end) {
            ListNode nex = ptrNext.next;
            ptrNext.next = prtStart;
            prtStart = ptrNext;
            ptrNext = nex;
        }
        end.next = prtStart;
    }

}
