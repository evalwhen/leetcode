package com.huzi.dynamicProgramming;

import java.util.Arrays;

public class MinHeightShelves {
  int[][] memo;
  public int minHeightShelves(int[][] books, int shelf_width) {
    memo = new int[books.length + 1][shelf_width + 1];
    return helper(books, 0, shelf_width, 0, shelf_width);
  }

  // 对每一本书，我们有两个选择，一是把它放在当前书架上，二是把它放在新的书架上。我们同时考虑这两种情况，选择最小的高度。
  private int helper(int[][] books, int cur, int shelf_remain, int cur_height, int shelf_width) {
    if (cur >= books.length) {
      return cur_height;
    } else {
      if (memo[cur][shelf_remain] != 0) return memo[cur][shelf_remain];

      int height = Integer.MAX_VALUE;
      if (shelf_remain >= books[cur][0]) {
        height = Math.min(height, helper(books, cur + 1,
                shelf_remain - books[cur][0], Math.max(cur_height, books[cur][1]), shelf_width));
      }

      height = Math.min(height, cur_height + helper(books, cur + 1,
              shelf_width - books[cur][0], books[cur][1], shelf_width));
      memo[cur][shelf_remain] = height;
      return height;
    }
  }
}
