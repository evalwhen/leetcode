package com.huzi.reverseLinkedList;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        return helper(head, null);
    }

    private ListNode helper(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        } else {
            ListNode next = head.next;
            head.next = newHead;
            return helper(next, head);
        }
    }

    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
     }
}
