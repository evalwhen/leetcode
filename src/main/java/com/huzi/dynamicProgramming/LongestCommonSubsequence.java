package com.huzi.dynamicProgramming;

public class LongestCommonSubsequence {
  public int longestCommonSubsequence(String text1, String text2) {
    int len1 = text1.length();
    int len2 = text2.length();
    int[][] dp = new int[len1][len2];

    for (int i = 0; i < len1; i++) {
      for (int j = 0; j < len2; j++) {
        if (text1.charAt(i) == text2.charAt(j)) {
          if (i == 0 || j == 0) {
            dp[i][j] = 1;
          } else {
            dp[i][j] = dp[i-1][j-1] + 1;
          }
        } else {
          if (i == 0 || j == 0) {
            if (j != 0) {
              dp[i][j] = dp[i][j-1];
            } else if (i != 0) {
              dp[i][j] = dp[i-1][j];
            } else {
              dp[i][j] = 0;
            }
          } else {
            dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
          }
        }
      }
    }
    return dp[len1-1][len2-1];
  }
}
