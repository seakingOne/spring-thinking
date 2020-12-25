package com.ynhuang.math.solution;

/**
 * @author YuHuang
 *
 */
public class SolutionMaxArea {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        SolutionMaxArea solution = new SolutionMaxArea();
        int result = solution.maxArea2Point(height);

        System.out.println("result:" + result);
    }

    public int maxArea(int[] height) {

        int max = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                max = Math.max((j - i) * minHeight, max);
            }
        }

        return max;
    }

    public int maxArea2Point(int[] height) {

        int max = 0;

        int i = 0;
        int j = height.length - 1;
        while (i <= j) {
            int minHeight = Math.min(height[i], height[j]);
            max = Math.max((j - i) * minHeight, max);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }

        }

        return max;
    }

}
