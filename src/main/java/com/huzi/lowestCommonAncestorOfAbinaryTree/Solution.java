package com.huzi.lowestCommonAncestorOfAbinaryTree;


import sun.font.CreatedFontTracker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pl = findPath(root, p, new ArrayList<TreeNode>());
        List<TreeNode> ql = findPath(root, q, new ArrayList<TreeNode>());
        int min = Math.min(pl.size(), ql.size());
        for (int i = 0; i < min; i++) {
            if (pl.get(i).val != ql.get(i).val) {
                return pl.get(i-1);
            }
        }
        return pl.get(min-1);
    }

    public List<TreeNode> findPath(TreeNode root, TreeNode p, List<TreeNode> res) {
        if (root == null) {
            return res;
        } else if (root.left == null && root.right == null) {
            res.add(root);
            if (root.val == p.val) {
                return res;
            } else {
                res.remove(root);
                return res;
            }
        } else {
            res.add(root);
            if (root.val == p.val) {
                return res;
            } else {
                List<TreeNode> l = findPath(root.left, p, res);
                if (!l.isEmpty() && l.get(l.size() - 1).val == p.val) {
                    return res;
                } else {
                    List<TreeNode> r = findPath(root.right, p, res);
                    if (!r.isEmpty() && r.get(l.size() - 1).val == p.val) {
                        return res;
                    } else {
                        res.remove(root);
                        return res;
                    }
                }
            }
        }
    }
}
