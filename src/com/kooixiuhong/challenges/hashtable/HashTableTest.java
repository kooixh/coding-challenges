package com.kooixiuhong.challenges.hashtable;

import com.kooixiuhong.commons.SolutionTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class HashTableTest extends SolutionTest {

    private static HashTableSolution hashTableSolution = new HashTableSolution();
    public static void run() throws InvocationTargetException, IllegalAccessException {
        System.out.println("HashTable tests");
        Method[] methods = HashTableTest.class.getDeclaredMethods();
        HashTableTest t = new HashTableTest();
        for (Method method : methods) {
            if (method.getName().startsWith("test"))
                method.invoke(t);
        }

    }

    public static void testWordFrequency() {
        System.out.println("Running word frequency tests");
        String[] words = {"this", "is", "a", "book", "with", "a", "lot", "of", "words", "in" ,"the", "book", "a"};

        System.out.print("test 1: ");
        int ex1 = 2;
        int actual = hashTableSolution.wordFrequency(words, "book");
        verify(ex1, actual);

        System.out.print("test 2: ");
        int ex2 = 3;
        actual = hashTableSolution.wordFrequency(words, "a");
        verify(ex2, actual);

        System.out.print("test 3: ");
        int ex3 = 0;
        actual = hashTableSolution.wordFrequency(words, "none");
        verify(ex3, actual);
    }


    public static void testMostKWord() {
        System.out.println("Running k frequent words tests");
        String[] words1 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k1 = 4;
        List<String> ex1 = Arrays.asList("the", "is", "sunny", "day");

        System.out.print("test 1: ");
        List<String>  actual = hashTableSolution.topKFrequentWords(words1, k1);
        verify(ex1, actual);

        String[] words2 = {"i", "love", "leetcode", "i", "love", "coding"};
        int k2 = 2;
        List<String> ex2 = Arrays.asList("i", "love");

        System.out.print("test 2: ");
        List<String>  actual2 = hashTableSolution.topKFrequentWords(words2, k2);
        verify(ex2, actual2);

    }


}
