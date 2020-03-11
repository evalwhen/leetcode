package com.huzi.symmetricTree;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return helper(root.left, root.right);
        }
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        } else {
            if (left.val != right.val) {
                return false;
            } else {
                return helper(left.left, right.right) && helper(left.right, right.left);
            }
        }
    }
}
