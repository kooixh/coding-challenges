package com.kooixiuhong.arrays;

public class ArrayTest {

    private static ArraySolution solution = new ArraySolution();
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";

    private static int totalTests = 0;
    private static int totalFailed = 0;
    private static int totalPassed = 0;

    public static int run() {
        System.out.println("Running array tests...");
        testQuestionOne();

        System.out.println("Completed array test, total " + totalTests + " tests.");
        System.out.println(ANSI_GREEN + totalPassed + " passed" + ANSI_RESET);
        System.out.println(ANSI_RED + totalFailed + " failed" + ANSI_RESET);
        return totalFailed;
    }

    public static void testQuestionOne() {
        int input[] = {1, 2, 3, 4, 5, 4};
        int expected = 4;
        System.out.print("Running Q1 test 1: ");
        if (expected == solution.questionOne(input)) {
            System.out.println(ANSI_GREEN + "passed" + ANSI_RESET);
            totalPassed++;
        } else {
            System.out.println(ANSI_RED + "failed" + ANSI_RESET);
            totalFailed++;
        }
        totalTests++;

    }
}
