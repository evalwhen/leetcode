package com.huzi.productOfArrayExceptSelf;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            swap(nums, 0, i);
            int res = 1;
            for (int j = 1; j < len; j++) {
                res *= nums[j];
            }
            result[i] = res;
        }
        return result;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public boolean isAnagram(String s, String t) {
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();

        Arrays.sort(schars);
        Arrays.sort(tchars);

        return Arrays.equals(schars, tchars);
    }
}
