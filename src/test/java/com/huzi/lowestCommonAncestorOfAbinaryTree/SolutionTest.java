package com.huzi.lowestCommonAncestorOfAbinaryTree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void lowestCommonAncestor() {
        TreeNode test = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6, null, null),
                        new TreeNode(
                                2,
                                new TreeNode(7, null, null),
                                new TreeNode(4, null, null))),
                new TreeNode(1,
                        new TreeNode(0, null, null),
                        new TreeNode(8, null, null)));
        TreeNode x = new Solution().lowestCommonAncestor(
                test,
                new TreeNode(5, null, null),
                new TreeNode(4, null, null));
        assertEquals(null,x);
//        List<TreeNode> x = new ArrayList<TreeNode>();
//         new Solution().findPath(
//                test,
//                new TreeNode(4, null, null),
//                x);
//        assertEquals(null, x);
    }

}