package com.huzi.substring;

public class SolutionLongestPalindromeRecur {
    public String longestPalindrome(String s) {
        int maxLen = s.length();

        int curLen = s.length();
        while (curLen >= 1) {
            for (int i = 0, j = curLen; j <= maxLen; i++, j++) {
                if (isPalindrome(s.substring(i, j-1))) {
                    return s.substring(i, j-1);
                }
            }
        }

        return "";
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return false;
        } else if (s.length() == 1) {
            return true;
        } else if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1);
        } else {
            if (s.charAt(0) != s.charAt(s.length() - 1)) {
                return false;
            } else {
                return isPalindrome(s.substring(1, s.length() - 1));
            }
        }
    }

    public boolean isPol(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }
}
