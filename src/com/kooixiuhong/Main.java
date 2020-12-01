package com.kooixiuhong;

import com.kooixiuhong.challenges.arrays.ArrayTest;
import com.kooixiuhong.challenges.graphs.GraphTest;
import com.kooixiuhong.challenges.graphs.trees.TreeTest;
import com.kooixiuhong.challenges.hashtable.HashTableTest;
import com.kooixiuhong.challenges.heaps.HeapTest;
import com.kooixiuhong.challenges.stacks.StackTest;
import com.kooixiuhong.challenges.strings.StringTest;
import com.kooixiuhong.commons.SolutionTest;
import com.kooixiuhong.commons.TestAggregator;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class Main {

    private static Reflections reflections = new Reflections("com.kooixiuhong.challenges");
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        int returnCode = 0;
        Set<Class<? extends SolutionTest>> allClasses = reflections.getSubTypesOf(SolutionTest.class);
        for (Class<? extends SolutionTest> c : allClasses) {
            if (c.getName().endsWith("Test")) {
                Method m = c.getMethod("run");
                m.invoke(c);
            }
        }
        returnCode = TestAggregator.aggregate();
        System.exit(returnCode);
    }
}
