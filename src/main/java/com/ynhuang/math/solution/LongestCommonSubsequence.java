package com.ynhuang.math.solution;

/**
 * @author YuHuang
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 *
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {

        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        int count = longestCommonSubsequence.longestCommonSubsequence("abcde", "ace");

        System.out.println(count);

    }

    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {

                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }

                }
            }
        }


        return dp[text1.length()][text2.length()];

    }

}
