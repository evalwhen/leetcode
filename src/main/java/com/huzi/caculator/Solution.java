package com.huzi.caculator;

import java.util.List;
import java.util.Stack;

class Solution {
    public int calculate(String s) {
        String str = s.trim();
        Stack<Integer> stk = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || i == str.length() - 1) {
                if (sign == '-') {
                    stk.push(-num);
                }
                if (sign == '+') {
                    stk.push(num);
                }
                if (sign == '*') {
                    stk.push(stk.pop() * num);
                }
                if (sign == '/') {
                    stk.push(stk.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        int total = 0;
        while (!stk.empty()) {
            total += stk.pop();
        }
        return total;
    }
}
