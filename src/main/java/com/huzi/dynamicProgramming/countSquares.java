package com.huzi.dynamicProgramming;

public class countSquares {
  public int countSquares(int[][] matrix) {
    int m = matrix.length;
    int n= matrix[0].length;

    int[][] dp = new int[m+1][n+1];
    int res = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++)
        if (matrix[i][j] == 1) {
          dp[i+1][j+1] = Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j+1])) + 1;
          res += dp[i+1][j+1];
        }
    }
    return res;
  }

  public int countSquresRecur(int[][] matrix) {
    int m = matrix.length;
    int n= matrix[0].length;
    int res = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++ ) {
        res += recur(matrix, i, j);
      }
    }
    return res;
  }
  // 矩阵 matrix 中，以 matrix[i,j]为右下角的 square 最大维度。
  // 同时也是也 matrix[i,j]为右下角的 square 个数。
  public int recur(int[][] matrix, int i, int j) {
    if (i < 0 || j < 0) {
      return 0;
    } else {
      if (matrix[i][j] == 0) {
        return 0;
      } else {
        return Math.min(
                recur(matrix, i-1, j-1),
                Math.min(recur(matrix, i, j-1),
                        recur(matrix, i-1,j))) + 1;
      }
    }
  }
}
