package com.huzi.linkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
  public Node copyRandomList(Node head) {

    if (head == null){
      return null;
    } else {
      Map<Node, Node> oldToNew = new HashMap<>();
      Node cur = head;
      while (cur != null) {
        oldToNew.put(cur, new Node(cur.val));
        cur = cur.next;
      }

      cur = head;
      while (cur != null) {
        oldToNew.get(cur).next = oldToNew.get(cur.next);
        oldToNew.get(cur).random = oldToNew.get(cur.random);
        cur = cur.next;
      }
      return oldToNew.get(head);
    }
  }

  private class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
}
