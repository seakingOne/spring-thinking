package com.ynhuang.math.solution.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author YuHuang
 * <p>
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 输入: [1,null,2,3]
 *
 */
public class InorderTraversal {

    public static void main(String[] args) {

        // add node
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);


        InorderTraversal inorderTraversal = new InorderTraversal();
        List<Integer> list = inorderTraversal.inorderTraversal(root);

        System.out.println(list);

    }

    /**
     * 通过迭代
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalForEach(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;

        }

        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        this.doAction(root, list);

        return list;
    }

    private void doAction(TreeNode root, List<Integer> list) {

        if (root.left != null) {
            doAction(root.left, list);
        }

        list.add(root.val);

        if (root.right != null) {
            doAction(root.right, list);
        }

    }
}


