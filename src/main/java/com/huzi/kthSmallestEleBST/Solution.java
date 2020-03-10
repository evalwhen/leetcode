package com.huzi.kthSmallestEleBST;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     int value = 0;
     int counter = 0;

    public int kthSmallest(TreeNode root, int k) {
        return helperIter(root, k);
    }

    private void helper(TreeNode t, int k) {
        if (t == null) {
            return;
        } else {
            helper(t.left, k);
            counter++;
            if (counter == k) {
                value = t.val;
            }
            helper(t.right, k);
        }
    }

    private int helperIter(TreeNode t, int k) {
        if (t==null) {
            return -1;
        }

        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode p = t;
        int counter = 0;

        while (!stk.isEmpty() || p != null) {
            if (p != null) {
                stk.push(p);
                p = p.left;
            } else {
                TreeNode node = stk.pop();
                counter++;
                if (counter == k) {
                    return node.val;
                }
                p = node.right;
            }
        }
        return -1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x; this.left = left; this.right = right;
    }
}
