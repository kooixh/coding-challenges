package com.kooixiuhong.commons;

import java.util.Arrays;

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

    protected static void printResult(String testName) {
        System.out.println("Completed " + testName + " test, total " + totalTests + " tests.");
        printGreen(totalPassed + " passed");
        printRed(totalFailed + " failed");
    }


    protected static void verify(Object expected, Object actual) {
        if (expected.equals(actual)) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
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

    protected static <T> void verifyArray(T[] expected, T[] actual) {
        if (Arrays.equals(expected, actual)) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            totalFailed++;
        }
    }

}
