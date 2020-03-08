package com.huzi.phoneLetterCombine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> m;
        m = new HashMap<Character, String>();
        m.put('2', "abc");
        m.put('3', "def");
        m.put('4', "ghi");
        m.put('5', "kjl");
        m.put('6', "mno");
        m.put('7', "pqrs");
        m.put('8', "tuv");
        m.put('9', "wxyz");
        List<String> ll;
        ll = new ArrayList<String>();
        for (int i = 0; i < digits.length(); i++) {
            Character c = digits.charAt(i);
            ll.add(m.get(c));
        }
        return combine(ll);
    }

    private List<String> combine(List<String> ll) {
        ArrayList<String> res = new ArrayList<String>();
        if (ll.size() == 0) {
            return res;
        } else if (ll.size() == 1) {
            String str = ll.get(0);
            for (int i = 0; i < str.length(); i++) {
                res.add(String.valueOf(str.charAt(i)));
            }
            return res;
        } else {
            List<String> tmp = lco(ll.get(0), ll.get(1));
            return ffl(tmp, combine(ll.subList(2, ll.size())));
        }
    }

    private List<String> ffl(List<String> lco, List<String> combine) {

        List<String> res = new ArrayList<String>();
        if (combine.size() == 0) {
            return lco;
        }
        for(String str1 : lco) {
            for(String str2 : combine) {
                res.add(str1 + str2);
            }
        }
        return res;
    }

    private List<String> lco(String s1, String s2) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < s1.length(); i++) {
            for (int j= 0; j < s2.length(); j++) {
                res.add(s1.charAt(i) + String.valueOf(s2.charAt(j)));
            }
        }
        return res;
    }
}