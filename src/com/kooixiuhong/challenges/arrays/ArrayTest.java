package com.kooixiuhong.challenges.arrays;

import com.kooixiuhong.commons.SolutionTest;

public class ArrayTest extends SolutionTest {

    private static ArraySolution solution = new ArraySolution();

    public static int run() {
        System.out.println("Running array tests...");
        testQuestionOne();

        System.out.println("Completed array test, total " + totalTests + " tests.");
        printGreen(totalPassed + " passed");
        printRed(totalFailed + " failed");
        return totalFailed;
    }

    public static void testQuestionOne() {
        int input[] = {1, 2, 3, 4, 5, 4};
        int expected = 4;
        System.out.print("Running Q1 test 1: ");
        if (expected == solution.questionOne(input)) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            totalFailed++;
        }
        totalTests++;
        // Testing case with no duplicate
        System.out.print("Running Q1 test 2: ");
        int input2[] = {1, 2, 3, 4,5};
        try {
            int output = solution.questionOne(input2);
            printRed("failed");
            totalFailed++;
        } catch (IllegalArgumentException iae) {
            printGreen("passed");
            totalPassed++;
        }
        totalTests++;
    }
}
