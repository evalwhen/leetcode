package com.huzi.dynamicProgramming;

public class UniquePath {
  // slow
  public int uniquePathsRecur(int m, int n) {
    return helper(1, 1, m, n);
  }

  private int helper(int x, int y, int m, int n) {
    if (x == m || y == n) {
      return 1;
    } else {
      return helper(x+1, y, m, n) + helper(x, y+1, m, n);
    }
  }

  public int uniquePathsRecur2(int m, int n) {
    int[][] memo = new int[m][n];
    return helper(m-1, n-1, memo);
  }

  private int helper(int m, int n, int[][] memo) {
    if (memo[m][n] != 0) {
      return memo[m][n];
    } else {
      if (m == 0 || n == 0) {
        memo[m][n] = 1;
        return 1;
      } else {
        memo[m][n] = helper(m-1, n, memo) +
                helper(m, n-1, memo);
        return memo[m][n];
      }
    }
  }


  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }

    for (int i = 1; i < n; i++) {
      dp[0][i] = 1;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i-1][j] + dp[i][j-1];
      }
    }
    return dp[m-1][n-1];
  }
}
