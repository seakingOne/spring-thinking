package com.ynhuang.math.solution;

/**
 * @author YuHuang
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 */
public class MoveZeroes {

    public static void main(String[] args) {

        int[] nums = {0,1,0,3,12};

        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes2Point(nums);

        for (int i : nums) {
            System.out.print(i + ", ");
        }

        System.out.println();

    }

    public void moveZeroes(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;

                    continue;
                }

            }

        }

    }

    public void moveZeroes2Point(int[] nums) {

        int i = 0;
        int j = 0;

        for (i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }

        }

        for (i = j; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

}
