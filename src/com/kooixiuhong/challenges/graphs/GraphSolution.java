package com.kooixiuhong.challenges.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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


    private List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1});
    /**
     *
     * You are given a m x n 2D grid initialized with these three possible values.
     *
     * -1 - A wall or an obstacle.
     * 0 - A gate.
     * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent
     * INF as you may assume that the distance to a gate is less than 2147483647.
     * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
     *
     * Ref: https://leetcode.com/problems/walls-and-gates/
     *
     * @return
     */
    public int[][] gatesAndWall(int[][] graph) {


        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int[] next : DIRECTIONS) {
                int r = p[0] + next[0];
                int c = p[1] + next[1];

                if (r < 0 || c < 0 || r >= graph.length || c >= graph[r].length || graph[r][c] != Integer.MAX_VALUE)
                    continue;

                graph[r][c] = graph[p[0]][p[1]] + 1;
                q.offer(new int[]{r, c});
            }

        }


        return graph;
    }

    /**
     *
     * There are a total of n courses you have to take labelled from 0 to n - 1.
     *
     * Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi]
     * this means you must take the course bi before the course ai.
     *
     * Given the total number of courses numCourses and a list of the prerequisite pairs,
     * return the ordering of courses you should take to finish all courses.
     *
     * If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
     *
     * @param k
     * @param prerequisites
     * @return
     */
    public int[] courseSchedule(int k, int[][] prerequisites) {
        List<Integer>[] adjList = new List[k];
        int[] indeg = new int[k];
        for (int i = 0; i < k; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] preq : prerequisites) {
            adjList[preq[1]].add(preq[0]);
            indeg[preq[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (indeg[i] == 0) q.offer(i);
        }
        int[] sorted = new int[k];
        int i = 0;
        while (!q.isEmpty()) {
            int c = q.poll();
            sorted[i] = c;
            for (int next : adjList[c]) {
                indeg[next]--;
                if (indeg[next] == 0) {
                    q.offer(next);
                }
            }
            i++;
        }
        return (i == k) ? sorted : new int[0];

    }


}
