package com.huzi.treeTraverse;

public class SolutionMinimumDepth {
    private int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 0);
        return min;
    }

    private void helper(TreeNode root, int cur) {
        if (root == null) {
            return;
        } else {
            cur++;
            if (root.left == null && root.right == null) {
                if (cur < min) {
                    min = cur;
                }
            } else {
                helper(root.left, cur);
                helper(root.right, cur);
            }
        }
    }
}
