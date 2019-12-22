package com.kooixiuhong.challenges.arrays;

import com.kooixiuhong.challenges.arrays.extras.Node;
import com.kooixiuhong.commons.SolutionTest;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest extends SolutionTest {

    private static ArraySolution solution = new ArraySolution();

    public static int run() {
        System.out.println("Array tests");
        testQuestionOne();
        testQuestionTwo();
        return totalFailed;
    }

    public static void testQuestionOne() {
        System.out.println("Running question 1 tests...");
        int input[] = {1, 2, 3, 4, 5, 4};
        int expected = 4;
        System.out.print("test 1: ");
        if (expected == solution.questionOne(input)) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            totalFailed++;
        }
        totalTests++;
        // Testing case with no duplicate
        System.out.print("test 2: ");
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

    public static void testQuestionTwo() {
        System.out.println("Running question 2 tests...");
        int input[] = {1, 2, 3, 4, 5};
        System.out.print("test 1: ");
        Node node = new Node(); // head of the list
        node.value = 1;
        Node current = node;
        //setting up node
        for (int i = 1; i < input.length ; i++) {
            Node newNode = new Node();
            newNode.value = input[i];
            current.next = newNode;
            current = current.next;
        }
        Node resultNode = solution.questionTwo(node);
        List<Integer> resultList = new ArrayList<>(); //reversed of input
        while (resultNode != null) {
            resultList.add(resultNode.value);
            resultNode = resultNode.next;
        }
        boolean isPassed = true;
        for (int i = input.length - 1; i >=0; i--) {
            if (input[i] != resultList.get((input.length - 1) - i)) {
                isPassed = false;
                break;
            }
        }
        if (isPassed) {
            totalPassed++;
            printGreen("passed");
        } else {
            totalFailed++;
            printRed("failed");
        }
        totalTests++;

        int input2[] = {4, 6, 7, 8, 10};
        System.out.print("test 2: ");
        Node node2 = new Node(); // head of the list
        node2.value = 4;
        Node current2 = node2;
        //setting up node
        for (int i = 1; i < input.length ; i++) {
            Node newNode = new Node();
            newNode.value = input2[i];
            current2.next = newNode;
            current2 = current2.next;
        }
        Node resultNode2 = solution.questionTwo(node2);
        List<Integer> resultList2 = new ArrayList<>(); //reversed of input
        while (resultNode2 != null) {
            resultList2.add(resultNode2.value);
            resultNode2 = resultNode2.next;
        }
        isPassed = true;
        for (int i = input2.length - 1; i >=0; i--) {
            if (input2[i] != resultList2.get((input2.length - 1) - i)) {
                isPassed = false;
                break;
            }
        }
        if (isPassed) {
            totalPassed++;
            printGreen("passed");
        } else {
            totalFailed++;
            printRed("failed");
        }
        totalTests++;
    }
}
