package com.huzi.swapNodesInPairs;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } else {
            ListNode first = head;
            ListNode second = head.next;
            ListNode rest = head.next.next;

            head = second;
            second.next = first;
            first.next = swapPairs(rest);
            return head;
        }
    }

    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
