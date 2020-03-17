package com.huzi.dynamicProgramming;

public class LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    int n = s.length();
    String res = "";
    boolean[][] history = new boolean[n][n];
    for(int i = n - 1; i >= 0; i--) {
      for (int j = n-1; j >= i; j--) {
        if (j - i + 1 == 1) {
          history[i][j] = true;
        } else if (s.charAt(i) == s.charAt(j)) {
          if (j - i + 1 == 2) {
            history[i][j] = true;
          } else if (history[i+1][j-1]) {
            history[i][j] = true;
          }
        }

        if (history[i][j] == true) {
          if (j - i + 1 > res.length()) {
            res = s.substring(i, j+1);
          }
        }
      }
    }
    return res;
  }


  public String longestPalindromeRecur(String s) {
    return helper(s, 0, s.length() - 1);
  }

  private String helper(String s, int i, int j) {
    int len = j - i + 1;
    if (len == 0) {
      return "";
    } else if (len == 1) {
      return s.substring(i, j+1);
    } else {
      if (s.charAt(i) == s.charAt(j)) {
        String str = helper(s, i+1, j-1);
        if (str.length() == len - 2) {
          return s.charAt(i) + str + s.charAt(j);
        } else {
          String str1 = helper(s, i+1, j);
          String str2 = helper(s, i, j - 1);
          if (str.length() > str1.length()) {
            if (str.length() > str2.length()) {
              return str;
            } else {
              return str2;
            }
          } else {
            if (str1.length() > str2.length()) {
              return str1;
            } else {
              return str2;
            }
          }
        }
      } else {
        String str1 = helper(s, i+1, j);
        String str2 = helper(s, i, j-1);
        if (str1.length() > str2.length()) {
          return str1;
        } else {
          return str2;
        }
      }
    }
  }
}
