package com.kooixiuhong.challenges.heaps;

import java.util.Arrays;

public class HeapSolution {

    /**
     *
     * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
     *
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosestPoints(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = points[i];
        }
        return ans;

    }
}
