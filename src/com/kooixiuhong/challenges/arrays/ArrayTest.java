package com.kooixiuhong.challenges.arrays;

import com.kooixiuhong.challenges.arrays.extras.ListNode;
import com.kooixiuhong.commons.SolutionTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayTest extends SolutionTest {

    private static ArraySolution solution = new ArraySolution();

    public static void run() throws InvocationTargetException, IllegalAccessException {
        System.out.println("Array tests");
        Method[] methods = ArrayTest.class.getDeclaredMethods();
        ArrayTest at = new ArrayTest();
        for (Method method : methods) {
            if (method.getName().startsWith("test"))
                method.invoke(at);
        }
    }

    public static void testArrayDups() {
        System.out.println("Running array duplicates tests...");
        int[] input = {1, 2, 3, 4, 5, 4};
        int expected = 4;
        System.out.print("test 1: ");
        verify(expected, solution.findADuplicateInArray(input));
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
    }

    public static void testUnsortedTwoSum() {
        System.out.println("Running unsorted Two Sum tests...");
        int[] nums = {4, 5, 6, 4, 2, 10};
        int k = 7;
        int[] expected = {1, 4};
        System.out.print("test 1: ");
        int[] actual = solution.unsortedTwoSum(nums, k);

        verifyIntArray(expected, actual);

        // Testing case with no duplicate
        System.out.print("test 2: ");
        int[] test2 = {1, 9, 2, 8, 2};
        int k2 = 5;
        int[] expected2 = {-1, -1};
        int[] actual2 = solution.unsortedTwoSum(test2, k2);

        verifyIntArray(expected2, actual2);

    }

    private static void testLivingPeople() {
        System.out.println("Running living people tests...");
        int[] birth = {1906, 1908, 1910, 1911, 1915};
        int[] death = {1909, 1920, 1915, 1923, 1924};
        int expected = 1915;
        int actual = solution.livingPeople(birth, death);
        System.out.print("test 1: ");
        verify(expected, actual);
    }

    private static void testSubSort() {
        System.out.println("Running sub sort tests...");
        int[] arr1 = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        int[] ex1 = {3,9};

        int[] actual1 = solution.subSortArray(arr1);
        System.out.print("test 1: ");
        verifyIntArray(ex1, actual1);

        int[] arr2 = {1,2,3,4,10,11,7,12,6,15,16,18,19};
        int[] ex2 = {4,8};

        int[] actual2 = solution.subSortArray(arr2);
        System.out.print("test 2: ");
        verifyIntArray(ex2, actual2);

        int[] arr3 = {1,2,3,4,5,6,7,8,19,15,16,17,9};
        int[] ex3 = {8,12};

        int[] actual3 = solution.subSortArray(arr3);
        System.out.print("test 3: ");
        verifyIntArray(ex3, actual3);

    }

    static void testSubArrayMaxSum() {
        System.out.println("Running sub array max sum tests...");
        int[] arr1 = {2, -8, 3, -2, 4, -10};
        int ex1 = 5;

        int actual1 = solution.subArrayWithMaxSum(arr1);
        System.out.print("test 1: ");
        verify(ex1, actual1);

        int[] arr2 = {-2,1,-3,4,-1,2,1,-5,4};
        int ex2 = 6;

        int actual2 = solution.subArrayWithMaxSum(arr2);
        System.out.print("test 2: ");
        verify(ex2, actual2);

        int[] arr3 = {-1};
        int ex3 = -1;

        int actual3 = solution.subArrayWithMaxSum(arr3);
        System.out.print("test 3: ");
        verify(ex3, actual3);

        int[] arr4 = {-2, -3, 4, -1, -2, 1, 5, -3};
        int ex4 = 7;

        int actual4 = solution.subArrayWithMaxSum(arr4);
        System.out.print("test 4: ");
        verify(ex4, actual4);
    }


    static void testCombinationSum() {
        System.out.println("Running sub array max sum tests...");

        int[] in1 = {2,3,6,7};
        int in1Target =7;
        List<List<Integer>> ex1 = new ArrayList<>();
        ex1.add(Arrays.asList(2,2,3));
        ex1.add(Collections.singletonList(7));

        List<List<Integer>> actual1 = solution.findCombinationSum(in1, in1Target);
        System.out.print("test 1: ");
        verifyListContainsAll(ex1, actual1);

    }

    static void testMinSubArraySumS() {
        System.out.println("Running min sub array s tests...");
        int[] arr1 = {2,3,1,2,4,3};
        int s1 = 7;
        int ex1 = 2;

        int actual1 = solution.subArraySumLessThanN(arr1, s1);
        System.out.print("test 1: ");
        verify(ex1, actual1);

        int[] arr2 = {1,2,1,2,10,3};
        int s2 = 18;
        int ex2 = 5;


        int actual2 = solution.subArraySumLessThanN(arr2, s2);
        System.out.print("test 2: ");
        verify(ex2, actual2);

    }


    public static void testMissingPositive() {
        System.out.println("Running missing positive tests...");
        int[] input = {1,2,0};
        int expected = 3;
        System.out.print("test 1: ");
        verify(expected, solution.findFirstMissingPositive(input));


        int[] input2 = {3,4,-1,1};
        int expected2 = 2;
        System.out.print("test 2: ");
        verify(expected2, solution.findFirstMissingPositive(input2));

        int[] input3 = {7,8,9,11,12};
        int expected3 = 1;
        System.out.print("test 3: ");
        verify(expected3, solution.findFirstMissingPositive(input3));
    }

    public static void testMergeLinkedList() {
        System.out.println("Running merge linked list tests...");

        System.out.print("test 1: ");
        ListNode list1 = new ListNode(1); // head of the list
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(2); // head of the list
        list2.next = new ListNode(5);
        list2.next.next = new ListNode(6);

        int[] expected = {1,2,2,3,5,6};
        ListNode actual = solution.mergeList(list1, list2);
        boolean isPassed = true;
        for (int i : expected) {
            if (actual == null || actual.value != i) {
                isPassed = false;
                break;
            }
            actual = actual.next;
        }
        if (isPassed) {
            totalPassed++;
            printGreen("passed");
        } else {
            totalFailed++;
            printRed("failed");
        }

        System.out.print("test 2: ");
        ListNode list21 = new ListNode(4); // head of the list
        list21.next = new ListNode(5);
        list21.next.next = new ListNode(6);

        ListNode list22 = new ListNode(2); // head of the list

        int[] expected2 = {2,4,5,6};
        ListNode actual2 = solution.mergeList(list21, list22);
        boolean isPassed2 = true;
        for (int i : expected2) {
            if (actual2 == null || actual2.value != i) {
                isPassed2 = false;
                break;
            }
            actual2 = actual2.next;
        }
        if (isPassed2) {
            totalPassed++;
            printGreen("passed");
        } else {
            totalFailed++;
            printRed("failed");
        }
    }


    static void testTrappingRainWater() {
        System.out.println("Running trapping rain water tests...");
        int[] arr1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int ex1 = 6;

        int actual1 = solution.trapRainWater(arr1);
        System.out.print("test 1: ");
        verify(ex1, actual1);

        int[] arr2 = {4,2,0,3,2,5};
        int ex2 = 9;

        int actual2 = solution.trapRainWater(arr2);
        System.out.print("test 2: ");
        verify(ex2, actual2);

        int[] arr3 = {1};
        int ex3 = 0;

        int actual3 = solution.trapRainWater(arr3);
        System.out.print("test 3: ");
        verify(ex3, actual3);

        int[] arr4 = {2, 3, 4, 1, 2, 1, 5, 3};
        int ex4 = 8;

        int actual4 = solution.trapRainWater(arr4);
        System.out.print("test 4: ");
        verify(ex4, actual4);
    }

    static void testMostContainerWater() {
        System.out.println("Running trapping rain water tests...");
        int[] arr1 = {1,8,6,2,5,4,8,3,7};
        int ex1 = 49;

        int actual1 = solution.containerMostWater(arr1);
        System.out.print("test 1: ");
        verify(ex1, actual1);

        int[] arr2 = {4,2,0,3,2,5};
        int ex2 = 20;

        int actual2 = solution.containerMostWater(arr2);
        System.out.print("test 2: ");
        verify(ex2, actual2);

        int[] arr3 = {4,3,2,1,4};
        int ex3 = 16;

        int actual3 = solution.containerMostWater(arr3);
        System.out.print("test 3: ");
        verify(ex3, actual3);

        int[] arr4 = {1,2,1};
        int ex4 = 2;

        int actual4 = solution.containerMostWater(arr4);
        System.out.print("test 4: ");
        verify(ex4, actual4);
    }


}
