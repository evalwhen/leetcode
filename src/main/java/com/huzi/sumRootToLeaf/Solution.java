package com.huzi.sumRootToLeaf;

public class Solution {
    public int sumNumbers(TreeNode root) {
        return helper( root, 0, 0);
    }

    private int helper(TreeNode root, int cur, int res) {
        if (root == null) {
            return res;
        } else {
            if (root.left == null && root.right == null) {
                return res + (root.val + (cur * 10));
            } else {
                return helper(root.left, root.val + (cur * 10),
                        helper(root.right, root.val + (cur * 10), res));
            }
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
