package com.huzi.dynamicProgramming;

//https://leetcode.com/problems/range-sum-query-mutable/
class NumArray {

  private SegmentTreeNode root;

  public NumArray(int[] nums) {
    root = buildTree(nums, 0, nums.length - 1);
  }

  public void update(int i, int val) {
    update(root, i, val);
  }

  private void update(SegmentTreeNode root, int i, int val) {
    if (root.start == root.end) {
      root.sum = val;
    } else {
      int mid = root.start + (root.end - root.start) / 2;
      if (i <= mid) {
        update(root.left, i, val);
      } else {
        update(root.right, i, val);
      }
      root.sum = root.left.sum + root.right.sum;
    }
  }

  public int sumRange(int i, int j) {
    return sumRange(root, i, j);
  }

  private int sumRange(SegmentTreeNode root, int start, int end) {
    if (root.start == start && root.end == end) {
      return root.sum;
    } else {
      int mid = root.start + (root.end - root.start) / 2;
      if (end <= mid) {
        return sumRange(root.left, start, end);
      } else if (start >= mid + 1) {
        return sumRange(root.right, start, end);
      } else {
        return sumRange(root.left, start, mid) + sumRange(root.right, mid+1, end);
      }
    }
  }

  private SegmentTreeNode buildTree(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    } else {
      SegmentTreeNode root = new SegmentTreeNode(start, end);

      if (start == end) {
        root.sum = nums[start];
      } else {
        int mid = start + (end - start) / 2;
        root.left = buildTree(nums, start, mid);
        root.right = buildTree(nums, mid+1, end);
        root.sum = root.left.sum + root.right.sum;
      }
      return root;
    }
  }

  private class SegmentTreeNode {
    int start;
    int end;
    SegmentTreeNode left;
    SegmentTreeNode right;
    int sum = 0;

    public SegmentTreeNode(int start, int end) {
      this.start = start;
      this.end = end;
      this.left = left;
      this.right = right;
      this.sum = sum;
    }
  }
}
