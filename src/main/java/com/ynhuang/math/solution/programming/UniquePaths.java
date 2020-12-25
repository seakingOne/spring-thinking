package com.ynhuang.math.solution.programming;

/**
 * @author YuHuang
 */
public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        int count = uniquePaths.uniquePaths(7, 2);
        System.out.println(count);

        int countDP = uniquePaths.uniquePathsDP(3, 2);
        System.out.println(countDP);

        String s1 = "77";
        String s2 = "333";

        String s3 = "122";

        System.out.println((s1.hashCode() < s3.hashCode()) && (s3.hashCode() < s2.hashCode()));
    }

    /**
     * 动态规划解决问题
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsDP(int m, int n) {

        int[][] nums = new int[m][n];

        for (int i = 0; i < m; i++) {
            nums[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            nums[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
            }
        }

        return nums[m - 1][n - 1];

    }



    public int uniquePaths(int m, int n) {

        int row = 0;
        int col = 0;

        int action = this.action(m, n, row, col);

        return action;

    }

    private int action(int m, int n, int row, int col) {

        if (row + 1 > m || col + 1 > n) {
            return 0;
        }

        if(row + 1 == m && col + 1 == n) {
            return 1;
        }

        return this.action(m, n, row + 1, col) + this.action(m, n, row, col + 1);

    }
}
