package com.huzi.PopulatingNextRightPointers;

import java.util.List;

public class Solution {

    public Node connect(Node root) {
        helper(root);
        return root;
    }

    private void helper(Node root) {
        if (root == null) {
            return;
        } else {
            if (root.left != null) {
                root.left.next = root.right;
            }
            if (root.next != null && root.right != null) {
                root.right.next = root.next.left;
            }
        }
        helper(root.left);
        helper(root.right);
    }
}
