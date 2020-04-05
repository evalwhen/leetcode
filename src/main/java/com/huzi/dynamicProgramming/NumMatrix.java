package com.huzi.dynamicProgramming;

//https://leetcode.com/problems/range-sum-query-2d-immutable/
public class NumMatrix {
  private int[][] dp;

  public NumMatrix(int[][] matrix) {
    matrix = matrix;
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return;
    }

    int m = matrix.length;
    int n = matrix[0].length;
    dp = new int[m+1][n+1];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dp[i+1][j+1] = matrix[i][j] + dp[i+1][j] + dp[i][j+1] - dp[i][j];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2+1] + dp[row1][col1];
  }
}
