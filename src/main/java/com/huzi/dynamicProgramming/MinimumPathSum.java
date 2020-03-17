package com.huzi.dynamicProgramming;

import java.util.Map;

public class MinimumPathSum {
  public int minPathSumRecur(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return -1;
    }
    int row = grid.length, col = grid[0].length;
    return helper(grid, row, col);
  }

  private int helper(int[][] grid, int row, int column) {
    if (row == 0 && column == 0) {
      return grid[row][column];
    } else if (row == 0 && column != 0) {
      return helper(grid, row, column - 1) + grid[row][column];
    } else if (row != 0 && column == 0) {
      return helper(grid, row - 1, column) + grid[row][column];
    } else {
      return grid[row][column] + Math.min(helper(grid, row - 1, column),
              helper(grid, row, column - 1));
    }
  }

  public int miniPathSumDp(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return -1;
    }

    int row = grid.length, col = grid[0].length;
    int[][] dp = new int[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = grid[i][j];
        } else if (i == 0 && j != 0) {
          dp[i][j] = dp[i][j-1] + grid[i][j];
        } else if (i != 0 && j == 0) {
          dp[i][j] = dp[i-1][j] + grid[i][j];
        } else {
          dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
        }
      }
    }
    return dp[row-1][col-1];
  }
}
