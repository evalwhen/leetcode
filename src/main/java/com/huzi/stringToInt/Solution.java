package com.huzi.stringToInt;

import org.omg.PortableInterceptor.INACTIVE;

public class Solution {
    public int myAtoi(String str) {
        String target = fetchToken(str);
        if (target.length() == 0) {
            return 0;
        }
        int result = 0;
        int sign;
        if (target.charAt(0) == '-') {
            sign = -1;
        } else {
            sign = 1;
        }
        for (int cur = 1; cur < target.length(); cur++) {
            int digit = target.charAt(cur) - '0';

            if (Integer.MAX_VALUE/10 < result || Integer.MAX_VALUE/10 == result &&
                    Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
        }
        return result * sign;
    }

    private String fetchToken(String str) {
        String t = str.trim();
        if (t.length() == 0) {
            return "";
        }
        char sign = '+';
        int i = 0;

        String res = "";
        if (isSign(t.charAt(0))) {
            sign = t.charAt(0);
            i += 1;
        }
        for (;i < t.length(); i++) {
            if (isDigit(t.charAt(i))) {
                res += t.charAt(i);
            } else {
                break;
            }
        }
        return sign + res;
    }
    private boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }
    private boolean isSign(char c) {
        return c == '-' || c == '+';
    }
}
