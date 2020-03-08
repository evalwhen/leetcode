package com.huzi.substring;

public class SolutionLongestPalindrome {
    private int start, end, max = 0;

    public String longestPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            extend(s, i, i);
            extend(s, i, i+1);
        }
        return s.substring(start, end);
    }

    private void extend(String s, int j, int k) {
        int maxLen = s.length();
        while (j >= 0 && k <= maxLen - 1 && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        if (max < k - j -1) {
            max = k - j -1;
            start = j + 1;
            end = k;
        }
    }
}
