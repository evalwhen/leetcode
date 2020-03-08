package com.huzi.multiplyString;

class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] pos = new int[n+m];

        for (int i = n - 1; i >=0; i--) {
            for (int j = m - 1; j >=0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i+j, p2 = i+j+1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (p == 0) {
                if (sb.length() != 0) {
                    sb.append(p);
                }
            } else {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
