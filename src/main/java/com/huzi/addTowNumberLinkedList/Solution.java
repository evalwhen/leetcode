package com.huzi.addTowNumberLinkedList;

import java.util.List;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1, l2, 0);
    }

    public ListNode helper(ListNode l1, ListNode l2, int carry) {

        if (l1 == null && l2 == null) {
            if (carry != 0) {
                return new ListNode(carry);
            } else {
                return null;
            }
        } else {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            ListNode newNode;
            if (sum >= 10) {
                newNode = new ListNode(sum-10);
                newNode.next = helper(l1 == null ? null : l1.next,
                        l2 == null ? null :l2.next, 1);

            } else {
                newNode = new ListNode(sum);
                newNode.next = helper(l1 == null ? null : l1.next,
                        l2 == null ? null :l2.next, 0);
            }
            return newNode;
        }
    }

    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
