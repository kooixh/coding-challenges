package com.kooixiuhong.challenges.heaps;

import com.kooixiuhong.commons.SolutionTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class HeapTest extends SolutionTest {

    private static HeapSolution heapSolution = new HeapSolution();

    public static void run() throws InvocationTargetException, IllegalAccessException {
        System.out.println("HashTable tests");
        Method[] methods = HeapTest.class.getDeclaredMethods();
        HeapTest t = new HeapTest();
        for (Method method : methods) {
            if (method.getName().startsWith("test"))
                method.invoke(t);
        }
    }

    static void testKClosestPoints() {
        System.out.println("Running K Closest Points tests");

        int[][] points1 = {{1, 3}, {-2, 2}};
        int k1 = 1;
        int[][] ex1 = {{-2, 2}};
        int[][] actual1 = heapSolution.kClosestPoints(points1, k1);
        System.out.print("test 1: ");
        verify2DArray(ex1, actual1);
    }

    static void testMeetingRooms() {
        System.out.println("Running meeting rooms tests");

        int[][] points1 = {{0, 30}, {5, 10}, {15, 20}};
        int ex1 = 2;
        int actual1 = heapSolution.meetingRoom(points1);
        System.out.print("test 1: ");
        verify(ex1, actual1);

        int[][] points2 = {{7, 10}, {2, 4}};
        int ex2 = 1;
        int actual2 = heapSolution.meetingRoom(points2);
        System.out.print("test 2: ");
        verify(ex2, actual2);
    }

}
