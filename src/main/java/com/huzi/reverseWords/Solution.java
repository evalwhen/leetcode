package com.huzi.reverseWords;

import java.util.Stack;

class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        Stack<String> st = new Stack<String>();
        for(String w : words) {
            if (!w.equals("")) {
                st.push(w.trim());
            }
        }
        StringBuilder sb = new StringBuilder();

        while (!st.empty()) {
            sb.append(st.pop());
            sb.append(" ");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
