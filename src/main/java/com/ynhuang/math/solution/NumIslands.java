package com.ynhuang.math.solution;

import java.util.LinkedList;

/**
 * @author YuHuang
 */
public class NumIslands {

    public static void main(String[] args) {

        char[][] grid = new char[][]{new char[] {'1', '1', '0', '0'}, new char[] {'1','0','0','0'}};

        NumIslands numIslands = new NumIslands();
        int i = numIslands.numIslands(grid);
        System.out.println(i);

    }

    public int numIslands(char[][] grid) {

        int row = grid.length;
        int column = grid[0].length;
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                if (grid[i][j] == '1') {


                    // 广度优先算法
                    LinkedList<String> queue = new LinkedList<>();
                    queue.add(i + ", " + j);

                    while (!queue.isEmpty()) {


                        String data = queue.remove();
                        String[] split = data.split(",");

                        int a = Integer.valueOf(split[0].trim());
                        int b = Integer.valueOf(split[1].trim());

                        // 上下左右处理
                        if (0 <= a && a < row && 0 <= b && b < column && grid[a][b] == '1') {
                            grid[a][b] = '0';
                            queue.add((a - 1) + ", " + b);
                            queue.add((a + 1) + ", " + b);
                            queue.add(a + ", " + (b - 1));
                            queue.add(a + ", " + (b + 1));
                        }

                    }

                    count++;
                }

            }
        }

        return count;

    }
}
