package com.huzi.dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {

  @Test
  void longestPalindrome() {
    assertEquals("a", new LongestPalindromicSubstring().longestPalindrome("a"));
    assertEquals("aa", new LongestPalindromicSubstring().longestPalindrome("aa"));
    assertEquals("aa", new LongestPalindromicSubstring().longestPalindrome("aab"));
    assertEquals("aba", new LongestPalindromicSubstring().longestPalindrome("aaba"));
  }

  @Test
  void longestRecur() {
    assertEquals("aa", new LongestPalindromicSubstring().longestPalindromeRecur("aa"));
    assertEquals("aba", new LongestPalindromicSubstring().longestPalindromeRecur("aaba"));
  }
}