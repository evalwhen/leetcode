package com.huzi.constructTree;

import java.util.ArrayList;
import java.util.Arrays;

public class SolutionConstructBTreeFromPreOrderAndInorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        } else {
            int v = preorder[0];
            int indexOfv = indexOf(inorder, v);

            int[] leftInorder = Arrays.copyOfRange(inorder, 0, indexOfv);
            int[] rightInorder = Arrays.copyOfRange(inorder, indexOfv + 1, inorder.length);
            int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1+indexOfv);
            int[] rightPreorder = Arrays.copyOfRange(preorder, 1+indexOfv, preorder.length);
            return new TreeNode(
                    v,
                    buildTree(leftPreorder, leftInorder),
                    buildTree(rightPreorder, rightInorder));
        }
    }

    private int indexOf(int[] nums, int v) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == v) {
                return i;
            }
        }
        return -1;
    }
}
