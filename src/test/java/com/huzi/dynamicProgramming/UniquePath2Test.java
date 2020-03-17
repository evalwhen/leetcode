package com.huzi.dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniquePath2Test {

  @Test
  void uniquePathsWithObstacles() {
    int[][] obstacles = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
    };
    assertEquals(0, new UniquePath2().uniquePathsWithObstacles(obstacles));
  }
}