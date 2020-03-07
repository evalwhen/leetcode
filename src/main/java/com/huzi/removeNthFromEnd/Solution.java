package com.huzi.removeNthFromEnd;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode runner = dummy;
        ListNode p = dummy;

        while (n != 0) {
            runner = runner.next;
            n--;
        }

        while (runner.next != null) {
            runner = runner.next;
            p = p.next;
        }
        p.next = p.next.next;

        return dummy.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
}
