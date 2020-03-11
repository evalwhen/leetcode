package com.huzi.searchA2DMatrix;

import java.util.Arrays;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int col = matrix[0].length - 1;
        int row = 0;
        while (col >= 0 && row <= matrix.length - 1) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for (int n : nums) {
            if (n != i) {
                return i;
            } else {
                i++;
            }
        }
        return i+1;
    }
}
