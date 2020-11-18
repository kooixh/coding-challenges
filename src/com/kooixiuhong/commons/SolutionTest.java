package com.kooixiuhong.commons;

import java.util.Arrays;
import java.util.List;

public abstract class SolutionTest {
    protected static final String ANSI_RED = "\u001B[31m";
    protected static final String ANSI_RESET = "\u001B[0m";
    protected static final String ANSI_GREEN = "\u001B[32m";

    protected static int totalTests = 0;
    protected static int totalFailed = 0;
    protected static int totalPassed = 0;

    protected static void printGreen(String str) {
        System.out.println(ANSI_GREEN + str + ANSI_RESET);
    }
    protected static void printRed(String str) {
        System.out.println(ANSI_RED + str + ANSI_RESET);
    }

    protected static void printResult() {
        System.out.println("Completed all tests, total " + (totalPassed + totalFailed) + " tests.");
        printGreen(totalPassed + " passed");
        printRed(totalFailed + " failed");
    }


    protected static void verify(Object expected, Object actual) {
        if (expected.equals(actual)) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            printRed("expected: " + expected.toString() + " got: " + actual.toString());
            totalFailed++;
        }
    }

    protected static void verifyIntArray(int[] expected, int[] actual) {
        if (Arrays.equals(expected, actual)) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            totalFailed++;
        }
    }

    protected static void verify2DArray(int[][] expected, int[][] actual) {

        boolean same = true;
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j ++) {
                if (expected[i][j] != actual[i][j]) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        if (same) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            totalFailed++;
        }
    }

    protected static <T> void verifyListContainsAll(List<T> expected, List<T> actual) {
        if (expected.containsAll(actual)) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            totalFailed++;
        }
    }

}
