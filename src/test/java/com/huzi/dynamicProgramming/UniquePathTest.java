package com.huzi.dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniquePathTest {

  @Test
  void uniquePathsRecur() {
    assertEquals(3, new UniquePath().uniquePathsRecur(3, 2));
    assertEquals(28, new UniquePath().uniquePathsRecur(7, 3));
  }

  @Test
  void uniquePathsRecur2() {
    assertEquals(28, new UniquePath().uniquePathsRecur2(50, 7));
  }
}