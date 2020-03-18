package com.huzi.dynamicProgramming;

public class ClimbingStairs {
  public int climbStairs(int n) {
    if (n < 1) {
      return 0;
    }

    int[] dp = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      if (i <= 2) {
        dp[i] = i;
      } else {
        dp[i] = dp[i-1] + dp[i-2];
      }
    }

    return dp[n];
  }

  public int climbStairs2(int n) {
    if (n < 1) {
      return 0;
    } else {
      if (n <= 2) {
        return n;
      } else {
        int prev1 = 2;
        int prev2 = 1;
        for (int i = 3; i <= n; i++) {
          int tmp = prev1;
          prev1 = prev1 + prev2;
          prev2 = tmp;
        }
        return prev1;
      }
    }
  }

  public int climbStairsRecru(int n) {
    if (n < 1) {
      return 0;
    } else if (n == 1) {
      return n;
    } else if (n == 2) {
      return 2;
    } else {
      return climbStairs(n-1) + climbStairs(n-2);
    }
  }
}
