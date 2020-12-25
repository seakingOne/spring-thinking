package com.ynhuang.math.solution.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YuHuang
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 */
public class GenerateParenthesis {

    public static void main(String[] args) {

        int n = 3;

        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generateParenthesis(n);
    }

    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();

        if (n == 0) {
            return list;
        }

//        this.doAction(0, n, "");
        this.doAction1(0, 0, n, "");

        return list;

    }

    private void doAction(int level, int n, String s) {

        // 终止条件
        if (level >= 2 * n) {
            System.out.println(s);
            return;
        }

        // 赋值
        String s1 = s + "{";
        String s2 = s + "}";

        // drill down
        this.doAction(level + 1, n, s1);
        this.doAction(level + 1, n, s2);

    }

    private void doAction1(int left, int right, int n, String s) {

        // 终止条件
        if (left == n && right == n) {
            System.out.println(s);
            return;
        }

        // 赋值
        String s1 = s + "{";
        String s2 = s + "}";

        // drill down
        if (left < n) {
            this.doAction1(left + 1, right, n, s1);
        }

        if (left > right) {
            this.doAction1(left, right + 1, n, s2);
        }

    }

}
