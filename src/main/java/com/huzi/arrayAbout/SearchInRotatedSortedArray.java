package com.huzi.arrayAbout;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int minIdx = findMin(nums);
        int last = nums.length - 1;
        int start, end;
        if (target <= nums[last]) {
            start = minIdx;
            end = last;
        } else {
            start = 0;
            end = minIdx;
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    //TODO: how to this.
    private int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
