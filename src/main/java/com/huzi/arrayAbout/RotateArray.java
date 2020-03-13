package com.huzi.arrayAbout;

public class RotateArray {

    public void rotate(int[] nums, int k) {
      for (int i = 0; i < k; i++) {
        for (int j = nums.length - 1; j >= 1; j--) {
          swap(nums, j-1, j);
        }
      }
    }

    private void swap(int[] nums, int i, int j) {
      if (i == j) {
        return;
      } else {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
      }
    }
}

