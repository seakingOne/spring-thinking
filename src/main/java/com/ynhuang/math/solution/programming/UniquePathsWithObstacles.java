package com.ynhuang.math.solution.programming;

/**
 * @author YuHuang
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 */
public class UniquePathsWithObstacles {

    /**
     * [[0,0],[1,1],[0,0]]
     * @param args
     */
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{new int[]{0, 0}, new int[]{1, 1}, new int[]{0, 0}};
        int i = UniquePathsWithObstacles.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        // 二维数组长度, 代表列
        int m = obstacleGrid.length;

        // 二维数组宽度，代表行
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for(int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        for(int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];

    }
}
