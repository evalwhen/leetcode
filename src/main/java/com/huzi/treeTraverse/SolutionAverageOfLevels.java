package com.huzi.treeTraverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SolutionAverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<Double>();
        if (root == null) {
            return res;
        }

        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        helper(lists, root, 0);

        for (List<Integer> l : lists) {
            res.add(sumList(l));
        }
        return res;
    }
    private void helper(List<List<Integer>> lists, TreeNode root, int level) {
        if (root == null) {
            return;
        } else {
            if (lists.size() <= level) {
                lists.add(new ArrayList<Integer>());
            }
            lists.get(level).add(root.val);

            helper(lists, root.left, level+1);
            helper(lists, root.right, level+1);
        }
    }
    private Double sumList(List<Integer> list) {
        long sum = 0;

        for (Integer i : list) {
            sum += i;
        }

        if (sum > Integer.MAX_VALUE) {
            return Double.valueOf(Integer.MAX_VALUE);
        } else if (sum < Integer.MIN_VALUE) {
            return Double.valueOf(Integer.MIN_VALUE);
        } else {
            return sum / (double) list.size();
        }
    }
}
