package com.huzi.generateParens;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void generateParenthesis() {
        System.out.println(new Solution().generateParenthesis(1));
        System.out.println(new Solution().generateParenthesis(2));
        System.out.println(new Solution().generateParenthesis(3));
    }
}