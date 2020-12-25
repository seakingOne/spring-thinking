package com.ynhuang.math.solution.tree;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public void addRightNode(TreeNode parentNode, TreeNode rightNode) {
        parentNode.right = rightNode;
    }

    public void addLeftNode(TreeNode parentNode, TreeNode leftNode) {
        parentNode.left = leftNode;
    }

}

