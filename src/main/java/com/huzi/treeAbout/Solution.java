package com.huzi.treeAbout;

public class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private  void helper(TreeNode root) {

        if (root == null) {
            return;
        } else {
            pathSum(root, 0, 0);
            pathSum(root.left, 0, 0);
            pathSum(root.right, 0, 0);
            helper(root.left);
            helper(root.right);
        }
    }

    private int pathSum(TreeNode root, int cur, int res) {

        if (root == null) {
            return res;
        } else {
            cur += root.val;
            res += cur;
            if (cur > max) {
                max = cur;
            }
            if (res > max) {
                max = res;
            }
            if (root.val > max) {
                max = root.val;
            }
            pathSum(root.left, cur, 0);
            pathSum(root.right, cur, 0);
            return pathSum(root.left, cur, pathSum(root.right, 0, 0));
        }
    }
}
