package com.kooixiuhong.challenges.arrays;

import com.kooixiuhong.challenges.arrays.extras.ListNode;
import com.kooixiuhong.commons.SolutionTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTest extends SolutionTest {

    private static ArraySolution solution = new ArraySolution();

    public static void run() throws InvocationTargetException, IllegalAccessException {
        System.out.println("Array tests");
        Method[] methods = ArrayTest.class.getDeclaredMethods();
        ArrayTest at = new ArrayTest();
        for (Method method : methods) {
            if (!method.getName().equals("run"))
                method.invoke(at);
        }
    }

    public static void testArrayDups() {
        System.out.println("Running array duplicates tests...");
        int[] input = {1, 2, 3, 4, 5, 4};
        int expected = 4;
        System.out.print("test 1: ");
        if (expected == solution.findADuplicateInArray(input)) {
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
            int output = solution.findADuplicateInArray(input2);
            printRed("failed");
            totalFailed++;
        } catch (IllegalArgumentException iae) {
            printGreen("passed");
            totalPassed++;
        }
        totalTests++;
    }

    public static void testReturnLinkedList() {
        System.out.println("Running reverse linked list tests...");
        int[] input = {1, 2, 3, 4, 5};
        System.out.print("test 1: ");
        ListNode listNode = new ListNode(); // head of the list
        listNode.value = 1;
        ListNode current = listNode;
        //setting up node
        for (int i = 1; i < input.length ; i++) {
            ListNode newListNode = new ListNode();
            newListNode.value = input[i];
            current.next = newListNode;
            current = current.next;
        }
        ListNode resultListNode = solution.reverseALinkedList(listNode);
        List<Integer> resultList = new ArrayList<>(); //reversed of input
        while (resultListNode != null) {
            resultList.add(resultListNode.value);
            resultListNode = resultListNode.next;
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

        int[] input2 = {4, 6, 7, 8, 10};
        System.out.print("test 2: ");
        ListNode listNode2 = new ListNode(); // head of the list
        listNode2.value = 4;
        ListNode current2 = listNode2;
        //setting up node
        for (int i = 1; i < input.length ; i++) {
            ListNode newListNode = new ListNode();
            newListNode.value = input2[i];
            current2.next = newListNode;
            current2 = current2.next;
        }
        ListNode resultListNode2 = solution.reverseALinkedList(listNode2);
        List<Integer> resultList2 = new ArrayList<>(); //reversed of input
        while (resultListNode2 != null) {
            resultList2.add(resultListNode2.value);
            resultListNode2 = resultListNode2.next;
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

    public static void testUnsortedTwoSum() {
        System.out.println("Running unsorted Two Sum tests...");
        int[] nums = {4, 5, 6, 4, 2, 10};
        int k = 7;
        int[] expected = {1, 4};
        System.out.print("test 1: ");
        int[] actual = solution.unsortedTwoSum(nums, k);
        if (Arrays.equals(expected, actual)) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            printRed("expected: " + Arrays.toString(expected) + " got: " + Arrays.toString(actual));
            totalFailed++;
        }
        totalTests++;
        // Testing case with no duplicate
        System.out.print("test 2: ");
        int[] test2 = {1, 9, 2, 8, 2};
        int k2 = 5;
        int[] expected2 = {-1, -1};

        if (Arrays.equals(expected2, solution.unsortedTwoSum(test2, k2))) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            totalFailed++;
        }

        totalTests++;
    }

    private static void testLivingPeople() {
        System.out.println("Running living people tests...");
        int[] birth = {1906, 1908, 1910, 1911, 1915};
        int[] death = {1909, 1920, 1915, 1923, 1924};
        int expected = 1915;
        int actual = solution.livingPeople(birth, death);
        System.out.print("test 1: ");
        if (expected == actual) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            totalFailed++;
        }
    }

    private static void testSubSort() {
        System.out.println("Running sub sort tests...");
        int[] arr1 = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        int[] ex1 = {3,9};

        int[] actual1 = solution.subSortArray(arr1);
        if (Arrays.equals(ex1, actual1)) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            System.out.println("expected: " + Arrays.toString(ex1) + " got: " + Arrays.toString(actual1));
            totalFailed++;
        }

        int[] arr2 = {1,2,3,4,10,11,7,12,6,15,16,18,19};
        int[] ex2 = {4,8};

        int[] actual2 = solution.subSortArray(arr2);
        if (Arrays.equals(ex2, actual2)) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            System.out.println("expected: " + Arrays.toString(ex2) + " got: " + Arrays.toString(actual2));
            totalFailed++;
        }

        int[] arr3 = {1,2,3,4,5,6,7,8,19,15,16,17,9};
        int[] ex3 = {8,12};

        int[] actual3 = solution.subSortArray(arr3);
        if (Arrays.equals(ex3, actual3)) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            System.out.println("expected: " + Arrays.toString(ex2) + " got: " + Arrays.toString(actual2));
            totalFailed++;
        }

    }


}
