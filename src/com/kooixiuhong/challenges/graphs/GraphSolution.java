package com.kooixiuhong.challenges.graphs;

public class GraphSolution {

    /**
     *
     * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
     *
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     *
     * Ref: https://leetcode.com/problems/number-of-islands/
     *
     * @param map
     * @return
     */
    public int numberOfIslands(int[][] map) {
        int ans = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    ans += numberOfIslandSearch(map, i, j);
                }
            }
        }
        return ans;
    }

    private int numberOfIslandSearch(int[][] map, int i, int j) {
        if (i < 0 || j < 0 || i >= map.length || j >= map[0].length || map[i][j] == 0)
            return 0;

        map[i][j] = 0;
        numberOfIslandSearch(map, i - 1, j);
        numberOfIslandSearch(map, i + 1, j);
        numberOfIslandSearch(map, i, j - 1);
        numberOfIslandSearch(map, i, j + 1);
        return 1;
    }

    /**
     *
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     *
     * The robot can only move either down or right at any point in time.
     * The robot is trying to reach the lower right corner
     *
     * How many possible unique paths are there?
     *
     * Ref: https://leetcode.com/problems/unique-paths/
     *
     *
     * @param m
     * @param n
     * @return
     */
    public int numberOfUniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }


}
