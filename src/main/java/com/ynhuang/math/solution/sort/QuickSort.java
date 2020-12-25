package com.ynhuang.math.solution.sort;

/**
 * @author YuHuang
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] array = new int[] {1,1,4};

        int start = 0;
        int end = array.length - 1;
        quickSort(array, start, end);

        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();

    }

    private static void quickSort(int[] array, int start, int end) {

        if (array.length < 0){
            return ;
        }

        /**
         * point值
         */
        int point = array[start];
        int left = start;
        int right = end;

        if (left >= right) {
            return;
        }

        while (left < right) {

            while (left < right && array[right] >= point) {
                right--;
            }

            array[left] = array[right];

            while (left < right && array[left] <= point) {
                left++;
            }

            array[right] = array[left];


        }

        array[right] = point;

        // 前到后递归
        quickSort(array, start, right - 1);
        // 后到前递归
        quickSort(array, right + 1, end);

    }

}
