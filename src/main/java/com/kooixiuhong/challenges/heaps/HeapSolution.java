package com.kooixiuhong.challenges.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

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

    /**
     *
     * Given an array of meeting time intervals consisting of start and
     * end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
     *
     * @param times
     * @return
     */
    public int meetingRoom(int[][] times) {
        Queue<Integer> endTimes = new PriorityQueue<>();
        Arrays.sort(times, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int needed = 0;
        for (int[] time : times) {
            if (endTimes.isEmpty()) {
                endTimes.offer(time[1]);
                needed++;
            } else {
                if (endTimes.peek() <= time[0]) {
                    endTimes.poll();
                    endTimes.offer(time[1]);
                } else {
                    endTimes.offer(time[1]);
                    needed++;
                }
            }
        }
        return needed;
    }
}
