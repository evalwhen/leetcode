package com.huzi.miniParser;


import com.sun.xml.internal.bind.v2.schemagen.xmlschema.NestedParticle;

import java.util.LinkedList;
import java.util.List;

//// This is the interface that allows for creating nested lists.
//  // You should not implement it, or speculate about its implementation
//interface NestedInteger {
//      /* Constructor initializes an empty nested list. */
////      NestedInteger();
//
//      /* Constructor initializes a single integer. */
////      public NestedInteger(int value);
//
//      // @return true if this NestedInteger holds a single integer, rather than a nested list.
//      public boolean isInteger();
//
//      // @return the single integer that this NestedInteger holds, if it holds a single integer
//      // Return null if this NestedInteger holds a nested list
//      public Integer getInteger();
//
//      // Set this NestedInteger to hold a single integer.
//      public void setInteger(int value);
//
//      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//      public void add(NestedInteger ni);
//
//      // @return the nested list that this NestedInteger holds, if it holds a nested list
//      // Return null if this NestedInteger holds a single integer
//      public List<NestedInteger> getList();
// }

interface NestedInteger{
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // Set this NestedInteger to hold a single integer.
      public void setInteger(int value);

      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      public void add(NestedInteger ni);

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
}
class ListNi implements NestedInteger {
    private NestedInteger car;
    private NestedInteger cdr;

    public boolean isInteger() {
        return false;
    }

    public Integer getInteger() {
        return null;
    }

    public void setInteger(int value) {
        car = new Atom(value);
    }

    public void add(NestedInteger ni) {
        cdr = ni;
    }

    public List<NestedInteger> getList() {
        return null;
    }
}
class Atom implements NestedInteger {
    private int val;

    public Atom(int value) {
        val = value;
    }

    public boolean isInteger() {
        return false;
    }

    public Integer getInteger() {
        return val;
    }

    public void setInteger(int value) {
        val = value;
    }

    public void add(NestedInteger ni) {
    }

    public List<NestedInteger> getList() {
        return null;
    }
}

public class Solution {
    public NestedInteger deserialize(String s) {
        NestedInteger ret = new Atom(0);

        if (s == null || s.length() == 0) return ret;
        if (s.charAt(0) != '[') {
            ret.add(new Atom(Integer.valueOf(s)));
        } else if (s.length() > 2) {
            int start = 1, counter = 0;
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                // 发现一个 Atom
                if (counter == 0 && c == ',' || i == s.length() - 1) {
                    ret.add(deserialize(s.substring(start, i)));
                    start = i+1;
                } else if (c =='[') {
                    counter++;
                } else if (c== ']') {
                    counter--;
                } else {
                    continue;
                }
            }
        }
        return ret;
    }
}
