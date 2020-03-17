package com.huzi.dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumPathSumTest {

  @Test
  void minPathSum() {
    int[][] test = {{1,3,1}, {1,5,1}, {4,2,1}};
    int[][] test1 = {{1,3,1}};
    int[][] test2 = new int[0][0];
    assertEquals(7, new MinimumPathSum().minPathSumRecur(test2));
  }
}