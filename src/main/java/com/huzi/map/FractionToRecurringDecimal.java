package com.huzi.map;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
  public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) {
      return "0";
    }

    StringBuilder result = new StringBuilder();
    result.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
    long num = Math.abs((long) numerator);
    long den = Math.abs((long) denominator);

    result.append(num / den);
    long remainder = num % den;

    if (remainder == 0) {
      return result.toString();
    }

    result.append(".");

    Map<Long, Integer> map = new HashMap<>();
    map.put(remainder, result.length());
    while (remainder != 0) {
      remainder *= 10;
      result.append(remainder / den);
      remainder %= den;
      if (map.containsKey(remainder)) {
        int index = map.get(remainder);
        result.insert(index, "(");
        result.append(")");
        break;
      } else {
        map.put(remainder, result.length());
      }
    }

    return result.toString();
  }
}
