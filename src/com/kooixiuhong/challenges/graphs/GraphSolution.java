package com.kooixiuhong.challenges.graphs;

public class GraphSolution {

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
