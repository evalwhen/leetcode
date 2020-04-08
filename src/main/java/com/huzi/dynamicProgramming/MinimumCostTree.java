package com.huzi.dynamicProgramming;

//https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
public class MinimumCostTree {

  public int mctFromLeafValues(int[] arr) {
    int n = arr.length;
    int[][] memo = new int[n][n];
    return helper(arr, 0, n - 1, memo);
  }

  private int helper(int[] arr, int s, int e, int[][] memo) {
    if (memo[s][e] > 0) {
      return memo[s][e];
    } else {
      if (s == e) {
        return 0;
      } else {
        int ans = Integer.MAX_VALUE;

        for (int i = s; i < e; i++) {
          int left = helper(arr, s, i, memo);
          int right = helper(arr, i+1, e, memo);

          int leftMax = 0, rightMax = 0;
          for (int j = s; j <= i; j++) {
            if (arr[j] > leftMax) {
              leftMax = arr[j];
            }
          }
          for (int j = i+1; j <= e; j++) {
            if (arr[j] > rightMax) {
              rightMax = arr[j];
            }
          }
          ans = Math.min(ans, left + right + leftMax * rightMax);
        }
        memo[s][e] = ans;
        return ans;
      }
    }
  }
}
