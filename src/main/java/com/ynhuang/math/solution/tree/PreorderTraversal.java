package com.ynhuang.math.solution.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author YuHuang
 * <p>
 * 给定一个二叉树，返回它的前序 遍历。
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 输入: [1,null,2,3]
 *
 */
public class PreorderTraversal {

    public static void main(String[] args) {

        // add node
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);


        PreorderTraversal inorderTraversal = new PreorderTraversal();
        List<Integer> list = inorderTraversal.preOrderTraversal(root);

        System.out.println(list);

    }

    /**
     * 迭代的方式前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversalForEach(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        TreeNode curr = root;
        Stack stack = new Stack();
        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                curr = curr.left;
            }

            stack.push(curr);

        }


        return list;
    }


    public List<Integer> preOrderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        this.doAction(root, list);

        return list;
    }

    private void doAction(TreeNode root, List<Integer> list) {

        list.add(root.val);

        if (root.left != null) {
            doAction(root.left, list);
        }

        if (root.right != null) {
            doAction(root.right, list);
        }

    }
}


