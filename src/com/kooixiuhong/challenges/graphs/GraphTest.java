package com.kooixiuhong.challenges.graphs;

import com.kooixiuhong.commons.SolutionTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GraphTest extends SolutionTest {

    private static GraphSolution graphSolution = new GraphSolution();

    public static void run() throws InvocationTargetException, IllegalAccessException {
        System.out.println("Graph tests");
        Method[] methods = GraphTest.class.getDeclaredMethods();
        GraphTest at = new GraphTest();
        for (Method method : methods) {
            if (method.getName().startsWith("test"))
                method.invoke(at);
        }
    }


    static void testNumberOfIsland() {
        int[][] map1 = {{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int expected1 = 1;
        int actual1 = graphSolution.numberOfIslands(map1);
        System.out.print("test 1: ");
        verify(expected1, actual1);

        int[][] map2 = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        int expected2 = 3;
        int actual2 = graphSolution.numberOfIslands(map2);
        System.out.print("test 2: ");
        verify(expected2, actual2);

    }

    static void testUniquePaths() {
        int ex1M = 7;
        int ex1N = 3;

        int ex1 = 28;
        int actual = graphSolution.numberOfUniquePaths(ex1M, ex1N);
        System.out.print("test 1: ");
        verify(ex1, actual);

        int ex2M = 3;
        int ex2N = 3;

        int ex2 = 6;
        int actual2 = graphSolution.numberOfUniquePaths(ex2M, ex2N);
        System.out.print("test 2: ");
        verify(ex2, actual2);
    }


}
