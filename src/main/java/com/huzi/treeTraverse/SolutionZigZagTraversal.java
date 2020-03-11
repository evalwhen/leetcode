package com.huzi.treeTraverse;

import java.util.*;

public class SolutionZigZagTraversal {

    // todo: write iterate version.
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, root, 0, true);
        return res;
    }

    private void helper(List<List<Integer>>res, TreeNode root, int level, boolean swh) {
        if (root == null) {
            return;
        } else {
            if (res.size() <= level) {
                res.add(new ArrayList<Integer>());
            }
            if (swh) {
                res.get(level).add(root.val);
            } else {
                res.get(level).add(0, root.val);
            }

            swh = !swh;
            helper(res, root.left, level + 1, swh);
            helper(res, root.right, level + 1, swh);
        }
    }
}
