package com.huzi.stringToInt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void myAtoi() {
        assertEquals(-22, new Solution().myAtoi("  +-22god"));
        assertEquals(-22, new Solution().myAtoi("-91283472332"));
    }
}