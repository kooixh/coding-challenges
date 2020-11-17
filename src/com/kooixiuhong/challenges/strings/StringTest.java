package com.kooixiuhong.challenges.strings;

import com.kooixiuhong.commons.SolutionTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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



}
