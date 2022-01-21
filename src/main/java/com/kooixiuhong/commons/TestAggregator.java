package com.kooixiuhong.commons;

/**
 *
 * Aggregate the test results at any given point
 *
 */
public class TestAggregator extends SolutionTest {
    public static int aggregate() {
        printResult();
        return (totalFailed > 0) ? 1 : 0;
    }
}
