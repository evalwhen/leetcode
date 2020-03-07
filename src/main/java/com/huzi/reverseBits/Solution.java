package com.huzi.reverseBits;

public class Solution {
    public int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int lastBit = n & 1;
            res = res << 1;
            res += lastBit;
            n = n >> 1;
        }

        return res;
    }
}
