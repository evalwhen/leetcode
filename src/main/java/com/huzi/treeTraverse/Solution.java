package com.huzi.treeTraverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
    int value = 0;
    int counter = 0;

    private int helperIter(TreeNode t, int k) {
        if (t==null) {
            return -1;
        }

        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode p = t;
        int counter = 0;

        while (!stk.isEmpty() || p != null) {
            if (p != null) {
                stk.push(p);
                p = p.left;
            } else {
                TreeNode node = stk.pop();
                counter++;
                if (counter == k) {
                    return node.val;
                }
                p = node.right;
            }
        }
        return -1;
    }

    private List<Integer> bfs(TreeNode root) {
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode p = root;
        List<Integer> l = new ArrayList<Integer>();

        while (!stk.isEmpty() || p != null) {
            if (p != null) {
                l.add(p.val);
                if (p.right != null) {
                    stk.push(p.right);
                }
                p = p.left;

            } else {
                p = stk.pop();
            }
        }
        return l;
    }

    private List<Integer> lastFirst(TreeNode t) {
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode p = t;
        List<Integer> l = new LinkedList<Integer>();
        while (!stk.isEmpty() || p != null) {
            if (p != null) {
                stk.push(p);
                if (p.right != null) {
                    stk.push(p.right);
                }
                p = p.left;
            } else {
                TreeNode node = stk.pop();
                l.add(node.val);
            }
        }
        return l;
    }



    public static void main(String[] args) {
        TreeNode test = new TreeNode(
                5,
                new TreeNode(
                        3,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                null),
                        new TreeNode(4, null, null)),
                new TreeNode(6, null, null));
        Solution solution = new Solution();
        System.out.println(solution.bfs(test));
        System.out.println(solution.lastFirst(test));
    }
}

