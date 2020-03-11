package com.huzi.constructTree;

public class SolutionConstructBSTreeFromSortedArray {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (end-start == 0) {
            return null;
        } else {
            int mid = start +(end-start) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, start, mid);
            root.right = helper(nums, mid + 1, end);
            return root;
        }
    }
}
