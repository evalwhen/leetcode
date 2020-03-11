package com.huzi.treeTraverse;

import java.util.ArrayList;
import java.util.List;

public class SolutionNaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) {
            return lists;
        } else {
            helper(lists, root, 0);
        }
        return lists;
    }

    private void helper(List<List<Integer>> res, Node root, int level) {
        if (root == null) {
            return;
        }

        if (res.size() <= level) {
            res.add(new ArrayList<Integer>());
        }

        res.get(level).add(root.val);

        for (Node n : root.children) {
            helper(res, n, level + 1);
        }
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
