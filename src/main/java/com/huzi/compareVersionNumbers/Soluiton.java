package com.huzi.compareVersionNumbers;


class Solution {
    public int compareVersion(String version1, String version2) {
        String[] vs1 = version1.split("\\.");
        String[] vs2 = version2.split("\\.");

        int l1 = vs1.length;
        int l2 = vs2.length;
        int maxLen = Math.max(vs1.length, vs2.length);

        for (int i = 0; i < maxLen; i++) {
            int v1, v2;
            v1 = i >= l1 ? 0 : Integer.valueOf(vs1[i]);
            v2 = i >= l2 ? 0 : Integer.valueOf(vs2[i]);
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            } else {
                continue;
            }
        }
        return 0;
    }
}
