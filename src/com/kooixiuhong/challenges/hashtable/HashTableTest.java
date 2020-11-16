package com.kooixiuhong.challenges.hashtable;

import com.kooixiuhong.commons.SolutionTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HashTableTest extends SolutionTest {

    private static HashTableSolution hashTableSolution = new HashTableSolution();
    public static void run() throws InvocationTargetException, IllegalAccessException {
        System.out.println("HashTable tests");
        Method[] methods = HashTableTest.class.getDeclaredMethods();
        HashTableTest t = new HashTableTest();
        for (Method method : methods) {
            if (!method.getName().equals("run"))
                method.invoke(t);
        }

    }

    public static void testWordFrequency() {
        System.out.println("Running word frequency tests");
        String[] words = {"this", "is", "a", "book", "with", "a", "lot", "of", "words", "in" ,"the", "book", "a"};

        System.out.print("test 1: ");
        int ex1 = 2;
        int actual = hashTableSolution.wordFrequency(words, "book");
        if (ex1 == actual) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            totalFailed++;
        }

        System.out.print("test 2: ");
        int ex2 = 3;
        actual = hashTableSolution.wordFrequency(words, "a");
        if (ex2 == actual) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            totalFailed++;
        }

        System.out.print("test 3: ");
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
