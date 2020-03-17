package com.huzi.dynamicProgramming;

public class MaximumSubArray {

  public int maxSubArray(int[] nums) {
    int res = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j <= i; j++) {
        int sub = sumArray(nums, j, i);
        if (sub > res) {
          res = sub;
        }
      }
    }
    return res;
  }

  private int sumArray(int[] nums, int i, int j) {
    int res = 0;

    while (i <= j) {
      res += nums[i];
      i++;
    }

    return res;
  }
}
