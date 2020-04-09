package com.huzi.dynamicProgramming;

import java.util.Arrays;

public class MinFallingPathSum {
  public int minFallingPathSum(int[][] A) {
    for (int i = 1; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j++) {
        A[i][j] += Math.min(Math.min(A[i-1][j], A[i-1][Math.max(0, j-1)]), A[i-1][Math.min(A[0].length - 1, j+1)]);
      }
    }

    return Arrays.stream(A[A.length - 1]).min().getAsInt();
  }

  // 递归版本
  public int minFallingPathSumRecur(int[][] A) {
    if (A == null || A.length == 0 || A[0].length == 0) {
      return 0;
    } else {
      int res = Integer.MAX_VALUE;
      int i = A.length - 1;
      int[][] memo = new int[A.length][A[0].length];

      for (int j = 0; j < A[0].length; j++) {
        res = Math.min(res, helper(A, i, j, memo));
      }
      return res;
    }
  }

  private int helper(int[][] A, int i, int j, int[][] memo) {
    if (memo[i][j] != 0) {
      return memo[i][j];
    } else {
      int res = 0;
      if (i == 0) {
        res = A[i][j];
      } else {
        res =  A[i][j] + Math.min(
                helper(A, i-1, j, memo),
                Math.min(
                        helper(A, i-1, Math.min(A[0].length - 1, j+1), memo),
                        helper(A, i-1, Math.max(0, j-1), memo)));
      }

      memo[i][j] = res;
      return res;
    }
  }
}

