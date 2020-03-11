package com.huzi.treeTraverse;

import java.util.ArrayList;
import java.util.List;

public class SolutionCousins {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
           return false;
        } else {
            List<Integer> lx = new ArrayList<Integer>();
            List<Integer> ly = new ArrayList<Integer>();
            findPath(lx, root, x);
            findPath(ly, root, y);
            if (lx.isEmpty() || ly.isEmpty()) {
                return false;
            } else {
                return lx.size() == ly.size() && lx.get(lx.size() - 2) != ly.get(ly.size() - 2);
            }
        }
    }

    private void findPath(List<Integer> l, TreeNode root, int x) {
        if (root == null) {
            return;
        } else {
            l.add(root.val);
            if (root.left == null && root.right == null) {
                if (root.val == x) {
                    return;
                } else {
                    l.remove(Integer.valueOf(root.val));
                }
            } else {
                if (root.val == x) {
                    return;
                } else {
                    findPath(l, root.left, x);
                    if (!l.isEmpty() && l.get(l.size() - 1) == x) {
                        return;
                    } else {
                        findPath(l, root.right, x);
                        if (!l.isEmpty() && l.get(l.size() - 1) == x) {
                            return;
                        } else {
                            l.remove(Integer.valueOf(root.val));
                        }
                    }
                }
            }
        }
    }
}
