package com.kooixiuhong.challenges.stacks;

import com.kooixiuhong.commons.SolutionTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Stack;

public class StackTest extends SolutionTest {

    private static StackSolution solution = new StackSolution();

    public static void run() throws InvocationTargetException, IllegalAccessException {
        System.out.println("Stacks tests");
        Method[] methods = StackTest.class.getDeclaredMethods();
        StackTest t = new StackTest();
        for (Method method : methods) {
            if (method.getName().startsWith("test"))
                method.invoke(t);
        }
    }
    public static void testSumOfStack() {
        System.out.println("Running sum of stack tests...");
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(5);
        stack.push(2);
        Object copyOfStack = stack.clone(); //test that ordering not changed
        System.out.print("test 1: ");
        int expectedSum = 17;
        int actualSum = solution.sumOfStack(stack);
        if (actualSum == expectedSum && stack.equals(copyOfStack)) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            totalFailed++;
        }
        totalTests++;
        //second test
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(12);
        stack1.push(20);
        stack1.push(50);
        copyOfStack = stack1.clone();
        System.out.print("test 2: ");
        expectedSum = 82;
        actualSum = solution.sumOfStack(stack1);
        if (actualSum == expectedSum && stack1.equals(copyOfStack)) {
            printGreen("passed");
            totalPassed++;
        } else {
            printRed("failed");
            totalFailed++;
        }
        totalTests++;
    }
}
