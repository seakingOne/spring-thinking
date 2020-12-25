package com.ynhuang.math.solution;

/**
 * @author YuHuang
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * f(n) = f(n-1) + f(n-2)
 *
 * 1 2 3 5
 *
 */
public class SolutionClimbStairs {

    public static void main(String[] args) {

        SolutionClimbStairs solutionClimbStairs = new SolutionClimbStairs();
        int result = solutionClimbStairs.climbStairsForLoop(1);

        System.out.println(result);

    }

    /**
     * 递归超时
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        int total = 0;

        int one = 1;
        int second = 2;

        if (n == 1) {
            return one;
        } else if (n == 2) {
            return second;
        }

        total = climbStairs(n - 1) + climbStairs(n - 2);

        return total;
    }

    /**
     * 循环处理
     * @param n
     * @return
     */
    public int climbStairsForLoop(int n) {

        int one = 1;
        int two = 2;
        int total = 0;

        if (n == one) {
            return one;
        }

        if (n == two) {
            return two;
        }

        for (int i = 2; i < n; i++) {

            total = one + two;
            one = two;
            two = total;

        }

        return total;
    }

}
