package com.huzi.simplifyPath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void simplifyPath() {
        assertEquals("", new Solution().simplifyPath("/a//b////c/d//././/.."));
    }
}