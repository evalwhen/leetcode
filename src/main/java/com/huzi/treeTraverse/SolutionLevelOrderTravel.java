package com.huzi.treeTraverse;

import org.omg.PortableInterceptor.INACTIVE;
import org.omg.PortableInterceptor.TRANSPORT_RETRY;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionLevelOrderTravel {
    public List<List<Integer>> levelOrderRecur(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (res.size() <= level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
    }
    public List<List<Integer>> levelOrderIter(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            int levelCount = queue.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
