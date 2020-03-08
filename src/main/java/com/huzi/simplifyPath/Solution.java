package com.huzi.simplifyPath;

import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<String>();
        Set<String> set = new HashSet<String>(Arrays.asList("..",".",""));
        for(String dir : path.split("/")) {
            if (dir.equals("..") && !stk.empty()) {
                stk.pop();
            } else {
                if (!set.contains(dir)) {
                    stk.push(dir);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for (String dir : stk) {
            sb.append(dir);
            sb.append("/");
        }

        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

}
