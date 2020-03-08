package com.huzi.substring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionLongestPalindromeRecurTest {

    @Test
    void longestPalindrome() {
        assertEquals(true, new SolutionLongestPalindromeRecur().isPalindrome("abaaba"));
        assertEquals(false, new SolutionLongestPalindromeRecur().isPol("baba"));
        assertEquals("bab", new SolutionLongestPalindromeRecur().longestPalindrome("baba"));
    }
}