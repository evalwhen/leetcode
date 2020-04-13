package com.huzi.dynamicProgramming;

public class MinimumCostTickets {
  public int minCostTickets(int[] days, int[] costs) {
    int[] mem = new int[days.length];
    return helper(days, costs, 0, mem);
  }

  private int helper(int[] days, int[] costs, int i, int[] memo) {
    int last = days.length - 1;

    int res = 0;
    if (i > last) {
      return 0;
    } else if (i == last) {
      res =  Math.min(costs[0], Math.min(costs[1], costs[2]));
      memo[i] = res;
      return res;
    } else {
      if (memo[i] > 0) {
        return memo[i];
      } else {
        int x1 = costs[0] + helper(days, costs, i+1, memo);
        int x7 = costs[1] + helper(days, costs, findNextIndex(days, i, days[i] + 6), memo);
        int x30 = costs[2] + helper(days, costs, findNextIndex(days, i, days[i] + 29), memo);
        res = Math.min(x1, Math.min(x7, x30));
        memo[i] = res;
        return res;
      }
    }

  }

  private int findNextIndex(int[] days, int start, int val) {
    for (int i = start; i < days.length; i++) {
      if (days[i] > val) {
        return i;
      }
    }

    return days.length;
  }
}
