package com.huzi.treeTraverse;

import sun.awt.image.ImageWatched;

import java.util.*;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorerHelper(list, root);
        return list;
    }

    public List<Integer> inorderTraversalIter(TreeNode root) {

        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;

        while (!stk.isEmpty() || cur != null) {
            if (cur != null) {
                stk.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stk.pop();
                list.add(node.val);
                cur = node.right;
            }
        }
        return list;
    }

    public List<Integer> preorderTraversalIter(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        } else {
            Stack<TreeNode> stk = new Stack<>();
            TreeNode cur = root;
            while (!stk.isEmpty() || cur != null) {
                if (cur != null) {
                    res.add(cur.val);
                    if (cur.right != null) {
                        stk.push(cur.right);
                    }
                    cur = cur.left;
                } else {
                    cur = stk.pop();
                }
            }
        }
        return res;
    }

    public List<Integer> postorderTraversalIter(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        } else {
            Stack<TreeNode> stk = new Stack<>();
            TreeNode cur = root;

            while (!stk.isEmpty() || cur != null) {
                if (cur != null) {
                    res.addFirst(cur.val);
                    if (cur.left != null) {
                        stk.push(cur.left);
                    }
                    cur = cur.right;
                } else {
                    cur = stk.pop();

                }
            }
            return res;
        }
    }

    private void inorerHelper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        } else {
            inorerHelper(res, root.left);
            res.add(root.val);
            inorerHelper(res, root.right);
        }
    }
}

