package com.ynhuang.math.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YuHuang
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 */
public class ThreeSum {

    public static void main(String[] args) {

        int[] nums = {0,0,0,-1, 1};

        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(nums);

        System.out.println(lists);

    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();

        Arrays.sort(nums);

        for (int x = 0; x < nums.length; x++) {

            if (x > 0 && nums[x - 1] == nums[x]) {
                continue;
            }

            int i = x + 1, j = nums.length - 1;

            while (i < j) {

                int total = nums[x] + nums[i] + nums[j];
                if (total == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[x]);
                    list.add(nums[i]);
                    list.add(nums[j]);

                    lists.add(list);

                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }

                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }

                    i++;
                    j--;

                } else if (total > 0) {
                    j--;
                } else {
                    i++;
                }

            }

        }

        return lists;
    }
}
