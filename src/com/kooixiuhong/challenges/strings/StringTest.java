package com.kooixiuhong.challenges.strings;

import com.kooixiuhong.commons.SolutionTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class StringTest extends SolutionTest {

    private static StringSolution stringSolution = new StringSolution();

    public static void run() throws InvocationTargetException, IllegalAccessException {
        System.out.println("String tests");
        Method[] methods = StringTest.class.getDeclaredMethods();
        StringTest t = new StringTest();
        for (Method method : methods) {
            if (method.getName().startsWith("test"))
                method.invoke(t);
        }
    }

    static void testLongestCommonSubstring() {
        System.out.println("Running longest common substring test");
        String ex1In1 = "abcde";
        String ex1In2 = "ace";

        int expected1 = 3;
        int actual1 = stringSolution.longestCommonSubString(ex1In1, ex1In2);
        System.out.print("test 1: ");
        verify(expected1, actual1);

        String ex2In1 = "abcddfwefefe";
        String ex2In2 = "acef";

        int expected2 = 4;
        int actual2 = stringSolution.longestCommonSubString(ex2In1, ex2In2);
        System.out.print("test 2: ");
        verify(expected2, actual2);


        String ex3In1 = "abcdef";
        String ex3In2 = "abcdef";

        int expected3 = 6;
        int actual3 = stringSolution.longestCommonSubString(ex3In1, ex3In2);
        System.out.print("test 3: ");
        verify(expected3, actual3);


        String ex4In1 = "abc";
        String ex4In2 = "def";

        int expected4 = 0;
        int actual4 = stringSolution.longestCommonSubString(ex4In1, ex4In2);
        System.out.print("test 4: ");
        verify(expected4, actual4);

    }

    static void testLongestCommonSubstringKDistinct() {
        System.out.println("Running longest common substring k distinct tests");


        String input1 = "eceba";
        int input1K = 2;
        int ex1 = 3;
        int actual = stringSolution.longestSubstringKDistinct(input1, input1K);
        System.out.print("test 1: ");
        verify(ex1, actual);

        String input2 = "aa";
        int input2K = 1;
        int ex2 = 2;
        int actual2 = stringSolution.longestSubstringKDistinct(input2, input2K);
        System.out.print("test 2: ");
        verify(ex2, actual2);


        String input3 = "sdfskfndsnjsdhfejsfn";
        int input3K = 4;
        int ex3 = 7;
        int actual3 = stringSolution.longestSubstringKDistinct(input3, input3K);
        System.out.print("test 3: ");
        verify(ex3, actual3);
    }

    static void testStringPartition() {
        System.out.println("Running String Partition tests");

        String input1 = "ababcbacadefegdehijhklij";
        List<Integer> ex1 = Arrays.asList(9, 7, 8);
        List<Integer> actual = stringSolution.partitionString(input1);
        System.out.print("test 1: ");
        verify(ex1, actual);

        String input2 = "tjqwdwqdqhsfhndsf";
        List<Integer> ex2 = Arrays.asList(1, 1, 15);
        List<Integer> actual2 = stringSolution.partitionString(input2);
        System.out.print("test 2: ");
        verify(ex2, actual2);

    }

    static void testLongestSubstringNoRepeating() {
        System.out.println("Running longest substring without repeating tests");

        String input1 = "abcabcbb";
        int ex1 = 3;
        int actual = stringSolution.longestSubStringWithoutRepeatingCharacter(input1);
        System.out.print("test 1: ");
        verify(ex1, actual);

        String input2 = "bbbbb";
        int ex2 = 1;
        int actual2 = stringSolution.longestSubStringWithoutRepeatingCharacter(input2);
        System.out.print("test 2: ");
        verify(ex2, actual2);


        String input3 = "pwwkew";
        int ex3 = 3;
        int actual3 = stringSolution.longestSubStringWithoutRepeatingCharacter(input3);
        System.out.print("test 3: ");
        verify(ex3, actual3);
    }



}
