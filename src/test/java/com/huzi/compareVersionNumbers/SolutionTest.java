package com.huzi.compareVersionNumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void compareVersion() {
        assertEquals(-1, new Solution().compareVersion("0.1", "1.0"));
    }
}