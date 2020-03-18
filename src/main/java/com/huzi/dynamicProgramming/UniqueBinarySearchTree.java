package com.huzi.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTree {
  // 重复计算较多
  // 计算 1..n 构成的不同二插搜索树的个数
  public int numTreesRecur(int n) {
    if (n <= 1) {
      return 1;
    } else {
      int sum = 0;
      // 计算分别以每个元素为 root 构成的二叉搜索树之和
      // 利用了 [1,2,3] 和 [2, 3, 4] 分别构成的二插搜索树个数相同
      // 也就是说长度相同的两个升序数组构成的二叉搜索树个数相同
      for (int i = 1; i <= n; i++) {
        sum += numTreesRecur(i-1) * numTreesRecur(n-i);
      }
      return sum;
    }
  }

  public int numTreesDP (int n) {
    int[] dp = new int[n+1];
    dp[0] = dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i] += dp[j-1] * dp[i-j];
      }
    }
    return dp[n];
  }

  public List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return new ArrayList<>();
    }
    return helper(1, n);
  }

  private List<TreeNode> helper(int start, int n) {
    List<TreeNode> res = new ArrayList<>();
    if (n <= 0) {
      res.add(null);
      return res;
    } else if (n == 1) {
      res.add(new TreeNode(start));
    } else {
      for (int i = 0; i < n; i++) {
        mergeLeftMidRight(start + i, helper(start, i), helper(start + i + 1, n - i - 1), res);
      }
    }
    return res;
  }

  private void mergeLeftMidRight(int mid, List<TreeNode> ls, List<TreeNode> rs, List<TreeNode> res) {
    for (TreeNode ln : ls) {
      for (TreeNode rn : rs) {
        TreeNode node = new TreeNode(mid);
        node.left = ln;
        node.right = rn;
        res.add(node);
      }
    }
  }
}
