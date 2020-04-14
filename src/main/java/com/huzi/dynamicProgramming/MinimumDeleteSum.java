package com.huzi.dynamicProgramming;

public class MinimumDeleteSum {
  public int minimumDeleteSum(String s1, String s2) {
    Integer[][] memo = new Integer[s1.length()][s2.length()];
    return helper(s1, s2, 0, 0, memo);
  }

  private int helper(String s1, String s2, int i, int j, Integer[][] memo) {
    if (i >= s1.length()) {
      return sum(s2, j);
    }

    if ( j >= s2.length()) {
      return sum(s1, i);
    }
    if (memo[i][j] != null) {
      return memo[i][j];
    } else {
      int ans;
      if (s1.charAt(i) == s2.charAt(j)) {
        ans = helper(s1, s2, i+1, j+1, memo);
      } else {
        int x1 = s1.charAt(i) + helper(s1, s2, i+1, j, memo);
        int x2 = s2.charAt(j) + helper(s1, s2, i, j+1, memo);

        ans =  Math.min(x1, x2);
      }
      memo[i][j] = ans;
      return ans;
    }
  }

  private int sum(String s, int i) {
    int res = 0;
    for (int j = i; j < s.length(); j++) {
      res += s.charAt(j);
    }
    return res;
  }
}
