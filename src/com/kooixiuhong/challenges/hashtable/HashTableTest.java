package com.kooixiuhong.challenges.hashtable;

import com.kooixiuhong.commons.SolutionTest;

public class HashTableTest extends SolutionTest {

    private static HashTableSolution hashTableSolution = new HashTableSolution();
    public static void run() {
        System.out.println("HashTable tests");
        testWordFrequency();

    }

    public static void testWordFrequency() {
        String[] words = {"this", "is", "a", "book", "with", "a", "lot", "of", "words", "in" ,"the", "book", "a"};

        System.out.println("test 1: ");
        int ex1 = 2;
        int actual = hashTableSolution.wordFrequency(words, "book");
        if (ex1 == actual) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            totalFailed++;
        }

        System.out.println("test 2: ");
        int ex2 = 3;
        actual = hashTableSolution.wordFrequency(words, "a");
        if (ex2 == actual) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            totalFailed++;
        }

        System.out.println("test 3: ");
        int ex3 = 0;
        actual = hashTableSolution.wordFrequency(words, "none");
        if (ex3 == actual) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            totalFailed++;
        }


    }


}
