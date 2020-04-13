package com.huzi.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CountSubstrings {
  private static HashMap<String, Boolean> mem = new HashMap<>();

  public int countSubstrings(String s) {
    int res = 0;
    if (s.length() == 0) {
      res = 0;
    } else if (s.length() == 1) {
      res = 1;
    } else {
      res = s.length();
      for (int l = s.length(); l >= 2; l--) {
        for (int i = 0; i <= s.length() - l; i++) {
          if (isPalin(s.substring(i, i + l), mem)) {
            res += 1;
          }
        }
      }
    }
    return res;
  }

  private boolean isPalin(String s, Map<String, Boolean> mem) {
    if (mem.containsKey(s)) {
      return mem.get(s);
    } else {
      Boolean res = false;

      if (s.length() <= 1) {
        res = true;
      } else {
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
          res = isPalin(s.substring(1, s.length() - 1), mem);
        } else {
          res = false;
        }
      }
      mem.put(s, res);
      return res;
    }
  }
}

class Solution {
  private int count = 0;

  public int countSubstrings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    } else {
      for (int i= 0; i < s.length(); i++) {
        extendPalindrome(s, i, i);
        extendPalindrome(s, i, i+1);
      }
    }
    return count;
  }

  private void extendPalindrome(String s, int left, int right) {
    while(left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
      count++;
      left--;
      right++;
    }
  }
}
