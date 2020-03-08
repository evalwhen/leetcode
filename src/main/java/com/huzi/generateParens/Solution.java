package com.huzi.generateParens;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res;
        res = new ArrayList<String>();
        helper(res, "", 0, 0, n);
        return res;
    }

    private void helper(List<String> res, String s, int l, int r, int n) {
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }

        if (l < n) {
            helper(res, s + "(", l+1, r, n);
        }

        if (r < l) {
            helper(res, s + ")", l, r+1, n);
        }
    }


}

