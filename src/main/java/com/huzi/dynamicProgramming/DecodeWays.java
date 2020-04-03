package com.huzi.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
  public int numDecodings(String s) {
    Map<String, Integer> memo = new HashMap<>();
    return recurHelper(s, memo);
  }

  private int recurHelper(String s, Map<String, Integer> memo) {
    if (memo.containsKey(s)) {
      return memo.get(s);
    } else {
      int res = 0;
      if (s.length() == 0) {
        res = 0;
      } else if (s.length() == 1) {
        int n = Integer.valueOf(s);
        if (n >= 1 && n <= 9) {
          res = 1;
        } else {
          res = 0;
        }
      } else if (s.length() == 2) {
        int n = Integer.valueOf(s);
        if (n < 10) {
          res = 0;
        } else if (n == 10) {
          res = 1;
        } else if (n <= 26) {
          res = 1 + recurHelper(s.substring(1, s.length()), memo);
        } else {
          res= recurHelper(s.substring(1, s.length()), memo);
        }
      } else {
        int n1 = Integer.valueOf(s.substring(0, 1));
        int n2 = Integer.valueOf(s.substring(0, 2));
        if (n1 >= 1 && n1 <= 9) {
          res += recurHelper(s.substring(1), memo);
        }

        if (n2 >= 10 && n2 <= 26) {
          res += recurHelper(s.substring(2), memo);
        }

      }
      memo.put(s, res);
      return res;
    }
  }
}
