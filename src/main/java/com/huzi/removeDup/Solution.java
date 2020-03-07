package com.huzi.removeDup;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int n : nums) {
            if (i < 2) {
                nums[i] = n;
                i++;
            } else {
                if (n > nums[i-2]) {
                    nums[i] = n;
                    i++;
                }
            }
        }
        return i;
    }
}
