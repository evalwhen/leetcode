package com.huzi.treeTraverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SolutionLevelOrderTravel2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        helper(lists, root, 0);
        for (int i = lists.size() - 1; i >= 0; i--) {
            res.add(lists.get(i));
        }
        return res;
    }

    private void helper(List<List<Integer>> lists, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (lists.size() <= level) {
            lists.add(new ArrayList<Integer>());
        }
        lists.get(level).add(root.val);

        helper(lists, root.left, level+1);
        helper(lists, root.right, level+1);
    }
}
