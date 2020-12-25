package com.ynhuang.math.solution;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 */
public class RemoveDuplicates {

    public static void main(String[] args) {

        int[] nums = {1,1,2};

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        removeDuplicates.removeDuplicates(nums);

        for (int i : nums) {
            System.out.print(i + ", ");
        }

        System.out.println();

    }

    public int removeDuplicates(int[] nums) {

        int size = 0;

        for (int j = 1;j < nums.length;j++) {
            if (nums[j] != nums[size]) {
                size++;
                nums[size] = nums[j];
            }
        }

        return size + 1;
    }
}
