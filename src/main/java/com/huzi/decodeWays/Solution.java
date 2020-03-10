package com.huzi.decodeWays;

class Solution {
    // slowly
    public int numDecodeRecur(String s) {
        if (s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            if (Integer.parseInt(s) == 0) {
                return 0;
            } else {
                return 1;
            }
        } else if (s.length() == 2) {
            int i2 = Integer.parseInt(s);
            int i1 = Integer.parseInt(s.substring(0,1));
            if (i1 != 0) {
                if (i2 >=1 && i2 <= 26) {
                    return  1 + numDecodeRecur(s.substring(1));
                } else {
                    return numDecodeRecur((s.substring(1)));
                }
            } else {
                return 0;
            }
        } else {
            int i2 = Integer.parseInt(s.substring(0, 2));
            int i1 = Integer.parseInt(s.substring(0, 1));
            if (i1 != 0) {
                if (i2 >= 1 && i2 <= 26) {
                    return numDecodeRecur(s.substring(1)) + numDecodeRecur(s.substring(2));
                } else {
                    return numDecodeRecur(s.substring(1));
                }
            } else {
                return 0;
            }
        }
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n ; i++) {
            int n1 = Integer.valueOf(s.substring(i-1, i));
            int n2 = Integer.valueOf(s.substring(i-2, i));

            if (n1 >= 1 && n1 <= 9) {
                dp[i] += dp[i-1];
            }

            if (n2 >= 10 && n2 <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }


    public int fib(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int prev2 = 0;
        int prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = prev1;
            prev1 = prev1 + prev2;
            prev2 = tmp;
        }
        return prev1;
    }
}
