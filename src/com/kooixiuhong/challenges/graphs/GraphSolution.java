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
}
