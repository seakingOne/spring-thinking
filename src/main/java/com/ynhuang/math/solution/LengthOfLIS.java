package com.ynhuang.math.solution;

/**
 * @author YuHuang
 *
 * 最长上升子序列
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();

        int[] nums = {10,9,2,5,3,7,101,18};
        int count = lengthOfLIS.lengthOfLIS(nums);

        System.out.println(count);
    }

    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        int result = 1;

        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < len; i++) {

            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            result = Math.max(result, dp[i]);
        }


        return result;

    }
}
