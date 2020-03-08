package com.huzi.groupAnagrams;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<String, List<String>>();
        for(String str : strs) {
            String h = stringHash(str);
            List <String> r = m.get(h);
            if (r == null) {
                List<String> l = new ArrayList<String>();
                l.add(str);
                m.put(h, l);
            } else {
                r.add(str);
            }
        }

        return new ArrayList<List<String>>(m.values());
    }
    private String stringHash(String str) {
        char[] ca = str.toCharArray();
        Arrays.sort(ca);
        String res = String.valueOf(ca);

        return res;
    }
}
