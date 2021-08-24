package xyz.mijazz.leetcode.utils;/**
 * @Time 2021-08-23 9:17 PM
 * @Author MijazzChan
 */

import com.sun.source.tree.Tree;

import java.util.stream.Stream;

public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }

    public static TreeNode buildTreeNodeFrom(int[] vals) {
        // TODO: TreeNode static constructor
        System.err.println("Pending Implementation...");
        return new TreeNode();
    }
}
